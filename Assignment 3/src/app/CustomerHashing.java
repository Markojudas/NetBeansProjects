package app;
import java.util.LinkedList;
import java.util.ListIterator;

//here we create the table, linkedList for chaining, 
public class CustomerHashing {
    
    private LinkedList<CustomerNode>[] table;

    public CustomerHashing() {
        table = new LinkedList[11];
        
        for(int i = 0; i < table.length; i++){
            table[i] = new LinkedList<>();
        }        
    }
    
    public void put(String key, Customer cust){
        int hashedKey = hashingCode(key);
        
        table[hashedKey].add(new CustomerNode(key, cust));
    }
    
    public Customer get(String key){
        int hashedKey = hashingCode(key);
        
        ListIterator<CustomerNode> iterator = table[hashedKey].listIterator();
        
        CustomerNode cust = null;
        while(iterator.hasNext()){
            cust = iterator.next();
            
            if(cust.key.equals(key)){
                return cust.customer;
            }            
        }
        return null;        
    }
    
    public Customer delete(String key){
        int hashedKey = hashingCode(key);
        
        ListIterator<CustomerNode> iterator = table[hashedKey].listIterator();
        
        CustomerNode cust = null;
        int index = -1;
        while(iterator.hasNext()){
            cust = iterator.next();
            index++;
            if(cust.key.equals(key)){
                break;
            }
        }
        
        if (cust == null){
            return null;
        }else{
            table[hashedKey].remove(index);
            return cust.customer;
        }        
    }

    
    public void printTable(){
        
        for(int i = 0; i < table.length; i++){
            if (table[i].isEmpty()){
                System.out.println("INDEX " + i + ": IS EMPTY\n");
            }
            else{
                System.out.println("INDEX " + i + ": ");
                ListIterator<CustomerNode> iterator = table[i].listIterator();
                while(iterator.hasNext()){
                    System.out.print(iterator.next().customer);
                    System.out.println("");
                }
            }
        }
    }
       
      
    private int hashingCode(String key){
        
        String last4 = key.substring(9);
        int sumLast4 = 0;
        
        String temp = "";
        int temp2 = 0;
        
        for (int i = 0; i < last4.length(); i++){
            temp = last4.substring(i, i + 1);
            temp2 = Integer.parseInt(temp);
            sumLast4 += temp2;  
        }
                
       return sumLast4 % table.length;        
    }
    
}
