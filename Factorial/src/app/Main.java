
package app;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.print ("\nEnter the number to calculate the factorial for: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int factorialValue = factorial(n);
        
        System.out.printf("%d! = %d\n", n, factorialValue);
    }
    
    public static int factorial(int n){
        if(n==0){
            return 1;
        }else{
            return (n * factorial(n-1));
        }        
    }
    
}
