
package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server implements Runnable {

    private final int serverPort;
    private ArrayList<ServerUser> userList = new ArrayList<>();
    

    public Server(int serverPort) {
        this.serverPort = serverPort;
    }
    
    public List<ServerUser> getUserList(){
        return userList;
    }
    
    @Override
    public void run(){
        
        try{
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while(true){                
                System.out.println("ABOUT TO ACCEPT CLIENT CONNECTION...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("ACCEPTED CONNECTION FROM " + clientSocket);

                    ServerUser worker = new ServerUser(this, clientSocket);
                    //workerList.add(worker);
                    Thread t = new Thread(worker);
                    t.start();
            }
        }
        catch(IOException e){            
        }         
    }

    void removeUser(ServerUser serverWorker) {
        userList.remove(serverWorker);
       
    }
}
