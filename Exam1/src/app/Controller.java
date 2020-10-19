/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author josrh
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       String[] array = {"hello", "good", "bye", "fuck", "you"}; 
        
        int n = array.length;
        
        for(int i = 0; i < n; i++){
            
            System.out.println(i);
            
            System.out.println(array[i]);
        }
             
    }
   
   
    
}
