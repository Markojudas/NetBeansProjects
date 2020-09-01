package stackdemo;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackDemo {

    public static void main(String[] args) {
               
        
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("STACK - LIFO - LAST IN FIRST OUT");
        System.out.println("=================================================");
        System.out.println("");


        
        Stack<String> s = new Stack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        
        System.out.println("ADDED: A, B, C");
        
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("QUEUE - FIFO - FIRST IN FIRST OUT");
        System.out.println("=================================================");
        System.out.println("");
           
               
        Queue<String> q = new LinkedList<>();
        q.add("A");
        q.add("B");
        q.add("C");
        
        System.out.println("ADDED: A, B, C");        
        
        
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("OUTPUT");
        System.out.println("=================================================");
        System.out.println("");
        
        System.out.print("STACK: ");
        while(s.size() > 0){
        System.out.print(s.pop() + " ");
        }
        
        System.out.println(" ");
        
        System.out.print("Queue: ");
        while(q.size() > 0){      
            System.out.print(q.remove() + " ");
        }
        
    }
    
}
