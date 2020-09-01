package TicketHolder;
import TicketSales.TicketSale;

public class TicketHolder extends TicketSale{
    
    private String state;
    private int age;
    public String name;
    
    public TicketHolder(String name, String state, int age){
        this.state = state;
        this.age = age;
        this.name = name;
    }
    
    public String getState(){
        return state;        
    }
    
    public int getAge(){
        return age;
    }
    
    
}
