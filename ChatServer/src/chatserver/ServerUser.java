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
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        
        outputStream.write("\n========== WELCOME TO THE ULTIMATE CHAT ROOM ==========\n\n".getBytes());
        outputStream.write("Please choose a username: #login <username> (4 - 10 characters)\n".getBytes());
               
            while((line = reader.readLine()) != null){
                String[] tokens = line.split(" ");
                if (tokens != null && tokens.length > 0){
                    String cmd = tokens[0];
                    
                    if ("#logoff".equalsIgnoreCase(cmd)){
                        doLogoff();
                        break;
                    }
                    else if("#login".equalsIgnoreCase(cmd)){
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
                                        outputStream.write("\nUSERNAME TAKEN, PLEASE TRY AGAIN\n\n".getBytes());
                                        nameIsTaken = true;
                                        break;
                                    }
                                }
                                if(!nameIsTaken){
                                    doLogin(outputStream, tokens);
                                }
                            }else{
                                doLogin(outputStream, tokens);                            
                            }
                            chatReady.signalAll();
                        }finally{
                            chatLock.unlock();
                        }
                    }    
                    else if("#status".equalsIgnoreCase(cmd)){
                        showUsers(outputStream);
                        outputStream.write("\n".getBytes());
                    }
                    else{
                        String msg = login + ": " + line + "\n";
                        sendMsg(msg);
                    }
                }    
            }       
            userSocket.close();
    }
    
    public String getLogin(){
        return login;
    }
    
    public void sendMsg(String msg) throws IOException{
        if(login != null){            
            for(ServerUser worker : userList){
                worker.send(msg);
            }          
        }               
    }
    
    public void showUsers(OutputStream outputStream) throws IOException{
        
        outputStream.write("\nUSERS CURRENTLY ONLINE: \n".getBytes());
        for(ServerUser worker : userList){
            outputStream.write((worker.getLogin() + "\n").getBytes());
        }
    }
    
    private void doLogin(OutputStream outputStream, String[] tokens) throws IOException{

        if(tokens.length == 2){
            String login = tokens[1];
            
            if ((login.length() >= 4) && (login.length() <= 10)){
                String msg = "\nLOGIN SUCESSFUL!!! YOU CAN NOW PARTICIPATE\n" + "TO DISCONNECT: #logoff\n" + "TO CHECK ONLINE USERS: #status\n\n";
                outputStream.write(msg.getBytes());
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
                String onlineMsg = login + " HAS COME ONLINE\n\n";
                for(ServerUser worker : userList){
                    
                    if(!login.equals(worker.getLogin())){
                        worker.send(onlineMsg);
                    }    
                }
            }
            else {
                String msg = "ERROR LOGIN\n";
                outputStream.write(msg.getBytes());
            }
        }       
    }
    
    public void send(String msg) throws IOException{
        if(login != null){
            outputStream.write(msg.getBytes());
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
            
            for(ServerUser worker : onlineUsers){
                    
                if(!login.equals(worker.getLogin())){
                    worker.send(onlineMsg);
                } 
            }
            userSocket.close();
            chatReady.signalAll();
        }finally{
            chatLock.unlock();
        }    
    }            
}
