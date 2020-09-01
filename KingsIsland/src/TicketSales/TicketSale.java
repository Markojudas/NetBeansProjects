package TicketSales;
import TicketHolder.TicketHolder;

public class TicketSale{
    
    private double price = 100.00;

    public void ticketPurchase(TicketHolder ticketHolder){
       
        int age = ticketHolder.getAge();
        String state = ticketHolder.getState();
         
        if(state.toLowerCase().equals("florida")){
            price = 80.00;
        }
        
        if(age <4){
            price = 0.00;
            System.out.println("");
            System.out.println("================================================");
            System.out.println("Entrance is Free for Kids under 4");
        }
        else if((age < 14) && (state.toLowerCase().equals("georgia"))){
            price = price - price * 0.18;
        }
        else if(age >= 65){
            double seniorPrice = 50.00;
            price = seniorPrice;
            if(state.toLowerCase().equals("texas")){
                price = seniorPrice - seniorPrice * 0.075;
            }
        }               
    }
    
    public double getPrice(){
        return price;
    }   
    
}
