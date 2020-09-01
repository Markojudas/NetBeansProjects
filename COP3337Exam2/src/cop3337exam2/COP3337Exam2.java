/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop3337exam2;
import java.util.Stack;
import java.util.LinkedList;
import java.util.ListIterator;

public class COP3337Exam2 {

    public static void main(String[] args) {

        LinkedList<String> letters = new LinkedList<>();
        
        letters.addLast("A");
        letters.addLast("D");
        letters.addLast("S");
        letters.addLast("H");
        
        System.out.println(letters);
        
        ListIterator<String> iterator = letters.listIterator();
        
        iterator.add("E");
        
        System.out.println(letters);
        
        iterator.next();
        iterator.next();
        
        iterator.add("M");
        
        System.out.println(letters);
        
        iterator.next();
        iterator.remove();
        
        System.out.println(letters);
        
        
               
    }
    
}
