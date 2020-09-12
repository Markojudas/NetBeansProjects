/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josrh
 */
public class IntegerDivision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 14;
        int denom = 7;
        
        if(num % denom != 0){
          double deci = ((double)num)/denom;
          System.out.println("Correct Answer: " + deci);
        }else{
           int  answer = num / denom;
           System.out.println("Incorrect answer: " + answer);
        }
    }
    
}
