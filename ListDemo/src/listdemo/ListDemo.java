package listdemo;

import java.util.LinkedList;
import java.util.ListIterator;


public class ListDemo {

    public static void main(String[] args) {
        
       LinkedList<String> staff = new LinkedList<>();
       
       staff.addLast("Diana");
       staff.addLast("Harry");
       staff.addLast("Romeo");
       staff.addLast("Tom");
       
       System.out.println("");
       System.out.println("==================================================");
       System.out.println("Original Staff");
       System.out.println("==================================================");
       System.out.println("");
       
       System.out.println(staff);
       
       System.out.println("");
       System.out.println("==================================================");
       System.out.println("Adding Juliet and Nina to the staff");
       System.out.println("==================================================");
       System.out.println("");
       
       ListIterator<String> iterator = staff.listIterator();
       iterator.next();
       iterator.next();
       
       //Adding Juliet and Nina AFTER Diana & Harry
       
       iterator.add("Juliet");
       iterator.add("Nina");
       
       System.out.println(staff);
       
       System.out.println("");
       System.out.println("==================================================");
       System.out.println("Removing Romeo from Staff");
       System.out.println("==================================================");
       System.out.println("");
       
       iterator.next();
       iterator.remove();
       
       System.out.println(staff);
       
       System.out.println("");
       System.out.println("==================================================");
       System.out.println("Final staff!");
       System.out.println("==================================================");
       System.out.println("");
       
       System.out.println(staff);
       System.out.println("Excepted: [Diana, Harry, Juliet, Nina, Tom");
    }
    
}
