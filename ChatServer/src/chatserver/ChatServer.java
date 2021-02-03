/*
Assignment 1
COP 4338 - Systems Programming - Spring 2021 - U01 1211
Instructor: Kianoush Gholamiboroujeni
Programmer: Jose R Hernandez

*/
package chatserver;

public class ChatServer {

    public static void main(String[] args) {
        
        int port = 8888 ;
        Server server = new Server(port);
        Thread t = new Thread(server);
        t.start();                                   
    }
    

    
}
