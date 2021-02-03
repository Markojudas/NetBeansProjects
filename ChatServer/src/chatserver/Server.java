/*
Assignment 1
COP 4338 - Systems Programming - Spring 2021 - U01 1211
Instructor: Kianoush Gholamiboroujeni
Programmer: Jose R Hernandez

*/
package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
This is the server that accepts connections from different users, creating new Threads for each new user
*/

public class Server implements Runnable {

    private final int serverPort;
    private ArrayList<ServerUser> userList = new ArrayList<>(); //this is the Main List collecting logged on users
    

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
