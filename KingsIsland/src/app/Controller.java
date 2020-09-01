package app;
import TicketHolder.TicketHolder;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        boolean wantsTicket = false;
        
        System.out.println("Would you like to purchase a ticket for King's Island?");
        String buyTicket = in.nextLine();

        if(buyTicket.substring(0,1).toLowerCase().equals("y")){
            wantsTicket = true;
        }
        
        while(wantsTicket){
            System.out.println("");
            
            System.out.println("Name: ");
            String name = in.nextLine();
            
            System.out.println("State: ");
            String state = in.nextLine();
            
            System.out.println("Age: ");
            int age = in.nextInt();
            in.nextLine();
            
            if(age > 0){
                TicketHolder ticketHolder = new TicketHolder(name, state, age);
        
                ticketPurchase(ticketHolder);
                displayTicketPurchase(ticketHolder);
            }else{
                System.out.println("Error! Wrong Age Input");
            }
            
        System.out.println("Would you like to buy another ticket?");
        String anotherTicket = in.nextLine();
        
        wantsTicket = anotherTicket.toLowerCase().substring(0,1).equals("y");
       }            
    }
    
    public static void ticketPurchase(TicketHolder ticketHolder){
        ticketHolder.ticketPurchase(ticketHolder);
    }
    
    public static void displayTicketPurchase(TicketHolder ticketHolder){
        System.out.println("=================================================");
        System.out.printf("The amount due is: $%.2f\n", ticketHolder.getPrice());
        System.out.println("=================================================");
    }
    
    
}
