package chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.PrintWriter;


/**
 * This class handles the socket (user connections)
 * The server accepts multiple connections with unique usernames
 * Commands are simply : #login, #status, #logoff
 * when a user logs in it announces that the user has logged on and it's added to collection of users
 * When a user logs off it announces that the user has disconnected the user is deleted from the collection of users
 */
public class ServerUser implements Runnable{
    
    private final Socket userSocket;
    public final Server server;
    private String login = null;
    private OutputStream outputStream;
    private PrintWriter out;
    private final List<ServerUser> userList;
    private final Lock chatLock;
    private final Condition chatReady;
    


    public ServerUser(Server server, Socket userSocket) {
        
        this.userList = server.getUserList();       
        this.userSocket = userSocket;
        this.server = server;
        chatLock = new ReentrantLock();
        chatReady = chatLock.newCondition();
    }

    @Override
    public void run(){
       try{
            handleClientSocket();
        }
        catch(IOException | InterruptedException e){
        }     
    }
    
    private void handleClientSocket() throws IOException, InterruptedException {

        InputStream inputStream = userSocket.getInputStream();
        outputStream = userSocket.getOutputStream();
        
        out = new PrintWriter(outputStream);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        
        //outputStream.write("\n========== WELCOME TO THE ULTIMATE CHAT ROOM ==========\n\n".getBytes());
        //outputStream.write("PLEASE CHOOSE A USERNAME: #login <username> (4 - 10 characters)\n".getBytes());
        
        String welcomeMsg1 = "\n========== WELCOME TO THE ULTIMATE CHAT ROOM ==========\n";
        String welcomeMsg2 = "PLEASE CHOOSE A USERNAME: #login <username> (4 - 10 characters)";
        
        out.println(welcomeMsg1);
        out.println(welcomeMsg2);
        out.flush();
        
            while((line = reader.readLine()) != null){
                String[] tokens = line.split(" ");
                if (tokens != null && tokens.length > 0){
                    String cmd = tokens[0];
                    
                    if ("#logoff".equalsIgnoreCase(cmd)){
                        doLogoff();
                        break;
                    }
                    else if("#login".equalsIgnoreCase(cmd)){
                        if(login == null){
                            chatLock.lock();
                            try{
                                List<ServerUser> users = new ArrayList<>();
 
                                if(userList.size() >= 1){
                                    boolean nameIsTaken = false;
                                    for(int i = 0; i < userList.size(); i++){
                                        ServerUser user = userList.get(i);
                                        users.add(user);
                                    }                            
                                    for(ServerUser userName : users){
                                        if(tokens[1].equalsIgnoreCase(userName.getLogin())){
                                            //outputStream.write("\nUSERNAME TAKEN, PLEASE TRY AGAIN\n\n".getBytes());
                                            out.println("\nUSERNAME TAKEN, PLEASE TRY AGAIN\n");
                                            out.flush();
                                            nameIsTaken = true;
                                            break;
                                        }
                                    }
                                    if(!nameIsTaken){
                                        doLogin(out, tokens);
                                    }
                                }else{
                                    doLogin(out, tokens);                            
                                }
                                chatReady.signalAll();
                            }finally{
                                chatLock.unlock();
                            }
                        }else{
                            out.println("\nYOU ARE ALREADY SIGNED IN\n");
                            out.flush();
                        }
                    }    
                    else if("#status".equalsIgnoreCase(cmd)){
                        if(login != null){
                            showUsers(out);
                            out.println();
                            out.flush();
                            //outputStream.write("\n".getBytes());                
                        }else{
                            //outputStream.write("PLEASE LOGIN IN FIRST\n".getBytes());
                            out.println("\nPLEASE LOGIN FIRST");
                            out.println();
                            out.flush();
                        }
                    }   
                    else if("#dm".equalsIgnoreCase(cmd)){
                        if(login != null){
                            sendDM(tokens);
                        }else{
                            out.println("\nPLEASE LOGIN FIRST");
                            out.flush();
                        }    
                    }
                    else{
                        if(login != null){
                            String msg = login + ": " + line;
                            sendMsg(msg);
                        }else{
                            //outputStream.write("PLEASE LOGIN IN FIRST\n".getBytes());
                            out.println("\nPLEASE LOGIN FIRST");
                            out.flush();
                        }     
                    }
                }    
            }       
            userSocket.close();
    }
    
    public String getLogin(){
        return login;
    }
    
    public void sendMsg(String msg) throws IOException{           
        for(ServerUser worker : userList){
            worker.send(msg);
        }               
    }
    
    public void showUsers(PrintWriter out) throws IOException{
        
        //outputStream.write("\nUSERS CURRENTLY ONLINE: \n".getBytes());
        out.println("\nUSERS CURRENTLY ONLINE: ");
        for(ServerUser worker : userList){
            //outputStream.write((worker.getLogin() + "\n").getBytes());
            out.println(worker.getLogin());
        }
        out.flush();
    }
    
    private void doLogin(PrintWriter out, String[] tokens) throws IOException{

        if(tokens.length == 2){
            String login = tokens[1];
            
            if ((login.length() >= 4) && (login.length() <= 10)){
                //String msg = "\nLOGIN SUCESSFUL!!! YOU CAN NOW PARTICIPATE\nTO DISCONNECT: #logoff\nTO CHECK ONLINE USERS: #status\n\n";
                //outputStream.write(msg.getBytes());
                String msg1 = "LOGIN SUCCESSFUL!!! YOU CAN NOW PARTICIPATE!";
                String msg2 = "TO DISCONNECT: #logoff";
                String msg3 = "TO CHECK ONLINE USERS: #status";
                out.println();
                out.println(msg1);
                out.println(msg2);
                out.println(msg3);
                out.println();
                out.flush();
                chatLock.lock();
                try{
                    userList.add(this);
                    chatReady.signalAll();
                }finally{
                    chatLock.unlock();
                }
                
                this.login = login;
                System.out.println("User logged in: " + login);

                //send other online users current user's status
                String onlineMsg = login + " HAS COME ONLINE\n";
                for(ServerUser worker : userList){
                    
                    if(!login.equals(worker.getLogin())){
                        worker.send(onlineMsg);
                    }    
                }
            }
            else {
                String msg = "ERROR LOGIN\n";
                //outputStream.write(msg.getBytes());
                out.println(msg);
                out.flush();
            }
        }       
    }
    
    public void send(String msg) throws IOException{
        if(login != null){
            //outputStream.write(msg.getBytes());
            out.println(msg);
            out.flush();
        }
    }

    private void doLogoff() throws IOException {
        
        chatLock.lock();
        try{
            server.removeUser(this);
            
            List<ServerUser> onlineUsers = userList;
            //send other online users current user's status
            String onlineMsg = login + " HAS DISCONNECTED\n";
            System.out.println("User logged off: " + login);
            
            for(ServerUser user : onlineUsers){
                    
                if(!login.equals(user.getLogin())){
                    user.send(onlineMsg);
                } 
            }
            chatReady.signalAll();
        }finally{
            chatLock.unlock();
        }
        userSocket.close();
    }
        
    private void sendDM(String[] tokens) throws IOException {
        
        if(tokens.length >=3){
            String sendTo = tokens[1];
            String msg = "";
            boolean userFound = false;
            
            for(int i = 2; i < tokens.length; i++){
                msg += tokens[i] + " ";
            }
            
            chatLock.lock();
            try{
                List<ServerUser> onlineUsers = userList;
                
                int endOfList = 0;
                for(ServerUser user : onlineUsers){
                    endOfList++;
                    if(sendTo.equalsIgnoreCase(user.getLogin())){
                        userFound = true;
                        if(userFound){
                            String completeMsg = "DM from " + login + ": " + msg;
                            user.send(completeMsg);
                            out.println("DM sent to " + sendTo + ": " + msg);
                            out.flush();
                        }
                    }else{
                        if((!userFound) && endOfList == onlineUsers.size()){
                            out.println("\nUSER NOT FOUND\n");
                            out.flush();                            
                        }    
                    }                    
                }
                chatReady.signalAll();
            }
            finally{
                chatLock.unlock();
            }
            
        }
        
    }
    
}
