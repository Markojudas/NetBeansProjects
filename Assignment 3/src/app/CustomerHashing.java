package app;
import java.util.LinkedList;
import java.util.ListIterator;

//here we create the table, linkedList for chaining, 
public class CustomerHashing {
    
    //creating an LinkedList array of CustomerNode
    private LinkedList<CustomerNode>[] table;
    
    //constructor
    //initiating the array with the size 11
    public CustomerHashing() {
        table = new LinkedList[11];
        
        //for loop to assigned a LinkList for each index
        for(int i = 0; i < table.length; i++){
            table[i] = new LinkedList<>();
        }        
    }
    
    //this is the put() method
    //it accepts the key and value
    //method calls the hashingCode() method to hash the key 
    //it then adds the a new CustomerNode (the customer created with the key and value)
    //to the LinkedList at the correspodning index (set by the hashedKey)
    public void put(String key, Customer cust){
        int index = hashingCode(key);
        
        table[index].add(new CustomerNode(key, cust));
    }
    
    //This is the get() method; it accepts the Key to search for a specific customer
    //it calls the hashingCode method to hash it and get the desired index
    //it then creates an ListIterator to to traverse/iterate through the LinkedList in the desired index
    //it creates another customerNode as it iterates through the List until it finds one
    //whose key equals the key used to call this method; then we have found the desired customer
    //if not; it returns null
    public Customer search(String key){
        int index = hashingCode(key);
        
        ListIterator<CustomerNode> iterator = table[index].listIterator();
        
        CustomerNode cust = null;
        while(iterator.hasNext()){
            cust = iterator.next();
            
            if(cust.key.equals(key)){
                System.out.println("**Customer " + cust.customer.name + " found at index " + index + "**\n");
                return cust.customer;
            }            
        }
        return null;        
    }
    
    //This is a smiliar code as the search() method. However it keeps track of the index
    //the desired customer is stored. The index variable is initialized at -1 becuase
    //the .next() would be index 0 and a customer could be stored at that index
    //the while loop breaks once we have found the desired customer index or we have iterated
    //the whole List. 
    //if the Customer was not found then it returns null
    //if the Customer is found it calls the remove() the index the customer is located
    public Customer delete(String key){
        int index = hashingCode(key);
        
        ListIterator<CustomerNode> iterator = table[index].listIterator();
        
        CustomerNode cust = null;
        int position = -1;
        while(iterator.hasNext()){
            cust = iterator.next();
            position++;
            if(cust.key.equals(key)){
                break;
            }
        }
        
        if (cust == null){
            return null;
        }else{
            table[index].remove(position);
            System.out.println("**Deleting " + cust.customer.name + " from index " + index + "**\n");
            return cust.customer;
        }        
    }

    //this is a simple display method printing the table.
    public void printTable(){
        
        for(int i = 0; i < table.length; i++){
            if (table[i].isEmpty()){
                System.out.println("INDEX " + i + ": \tEMPTY SLOT\n");
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
       
    //this is my hashing function
    //it accepts the complete phone number
    //then it gets the last 4 digits (index 9 through 13)
    //for loop gets each digit and gets their sum stored into sumLast4 variable as an int
    //the method returns the sumLast4 mod the length of table which is 11.
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
