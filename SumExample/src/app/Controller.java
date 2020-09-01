
package app;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter a postive integer: ");
        double totalSum = in.nextDouble();
        
        System.out.println(sum(totalSum));       
    }
    
    public static double sum(double i){

        if (i == 0){
            return 1;
        }
        
       double sum = (1/Math.pow(4, i));
       double finalSum;
       
       finalSum = sum + sum(i-1);
       return finalSum;     
    }
    
}
