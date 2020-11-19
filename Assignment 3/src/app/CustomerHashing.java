package app;

//here we create the table, linkedList for chaining, 
public class CustomerHashing {
    
    private CustomerNode[] table;
    
    public CustomerHashing(){
        
        table = new CustomerNode[11];        
    }
    
    public void put(String key, Customer value){
        
        int hashedIndex = hashingCode(key);
        CustomerNode head = table[hashedIndex];
        
        //System.out.println(hashedIndex);
        
        
        while (head != null){
            if(head.cust.phone.substring(6).equals(key)){
                head.cust = value;
                return;
            }
            head = head.next;
        }
        
        
        head = table[hashedIndex];
        CustomerNode node = new CustomerNode(value);
        node.next = head;
        table[hashedIndex] = node;
        
    }
    
    public void printTable(){
        for(int i = 1; i < table.length; i++){
            if (table[i] == null){
                System.out.println("EMPTY SLOT AT INDEX: " + i);
            }
            else{
                System.out.print("INDEX" + i + " CONTAINS: ");
                System.out.print(table[i].cust);
                System.out.println("");
            }

        }
    }
  
    private int hashingCode(String key){
        
        int sumLast4 = 0;
        
        String temp = "";
        int temp2 = 0;
        
        for (int i = 0; i < key.length(); i++){
            temp = key.substring(i, i + 1);
            temp2 = Integer.parseInt(temp);
            sumLast4 += temp2;           
        }
               
       return sumLast4 % table.length;        
    }
    
}
