package app;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        
        System.out.println("Selection number to test out: ");
        Scanner in = new Scanner(System.in);
        int testNum = in.nextInt();    
        System.out.println("");       
       
        System.out.println("BINARY CONVERTION: ");
        System.out.println(convert(testNum));
        System.out.println("");
        
        System.out.println("Recursion method that returns the number of 1's");
        System.out.println(ones(testNum));
        
        

        
    }
    
    public static String convert(int n){
       System.out.println("n: " + n);
        if (n == 0){
            return "";                        
        }     
        
        return convert(n/2) + "" + (n%2);
    }   
    
    public static int ones(int n){
        System.out.println("n: " + n);
        if(n < 2){
            return n;
        }
        return n % 2 + ones(n/2);
    }
}
