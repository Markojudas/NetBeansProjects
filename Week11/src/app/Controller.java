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
        // TODO code application logic here
        
        try{
            int[] numbers = new int[3];
            System.out.println("Number at index 5: " + numbers[5]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown " + e);
            System.out.println(e.getMessage());
        }
        System.out.println("Done");
    }
    
}
