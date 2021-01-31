/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author josrh
 */
public class BankClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        final int SBAP_PORT = 8888;
        
        try(Socket s = new Socket("localhost", SBAP_PORT)){
            
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);
            
            String command = "DEPOSIT 3 1000\n";
            System.out.print("Sending: " + command);
            out.print(command);
            out.flush();
            String response = in.nextLine();
            System.out.println("RECEIVING: " + response);
            
            command = "WITHDRAW 3 250\n";
            System.out.print("SENDING: " + command);
            out.print(command);
            out.flush();
            response = in.nextLine();
            System.out.println("RECEIVING: " + response);
            
            command = "QUIT\n";
            System.out.println("SENDING: " + command);
            out.print(command);
            out.flush();                     
        }
    }
    
}
