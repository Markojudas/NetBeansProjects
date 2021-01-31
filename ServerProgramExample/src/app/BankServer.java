/*
A Server Program Example
 */
package app;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BankServer {
   
    
    public static void main(String[] args) throws IOException  {
        
        final int ACCOUNTS_LENGTH = 10; //how many accounts in the bank
        Bank bank = new Bank(ACCOUNTS_LENGTH);
        final int SBAP_PORT = 8888;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("WAITING FOR CLIENTS TO CONNECT...");
        
        while(true){
                Socket s = server.accept();
                System.out.println("CLIENT CONNECTED");
                BankService service = new BankService(s, bank);
                Thread t = new Thread(service);
                t.start();                            
        }        
    }    
}
