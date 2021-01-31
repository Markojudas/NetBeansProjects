package app;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
        
/*
This class executes Simple Bank Access Protocol (see book) commands from a socket
*/

public class BankService implements Runnable {
    
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Bank bank;
    
    /*
    The constructor that processes commands from a socket for a bank
    */
    
    public BankService(Socket aSocket, Bank aBank){
        s = aSocket;
        bank = aBank;
    }
    
    @Override
    public void run(){
        
        try{
            try{
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            }
            catch (InterruptedException ex) {
                Logger.getLogger(BankService.class.getName()).log(Level.SEVERE, null, ex);
            }            finally{
                s.close();
            }
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }
    
    //Executes all commands until the QUIT command or the end of input
    
    public void doService() throws IOException, InterruptedException{
        
        while(true){
            
            if(!in.hasNext()) return;
            String command = in.next();
            if(command.equals("QUIT")) return;
            else executeCommand(command);
            
        }
    }
    
    //the commands
    
    public void executeCommand(String command) throws InterruptedException{
        
        int account = in.nextInt();
        if(command.equals("DEPOSIT")){
            double amount = in.nextDouble();
            bank.deposit(account, amount);            
        }
        else if(command.equals("WITHDRAW")){
            double amount = in.nextDouble();
            bank.withdraw(account, amount);
        }
        else if(!command.equals("BALANCE")){
            out.println("invalid command");
            out.flush();
            return;
        }
        out.println(account + " " + bank.getBalance(account));
        out.flush();
    }
}
