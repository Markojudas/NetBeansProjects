package app;
import java.util.Scanner;


public class Controller {

    public static void main(String[] args) {
        
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("Decimal to Binary");
        System.out.println("=================================================");
        System.out.println("");
        
        Scanner in = new Scanner(System.in);
        
        int n;
        
        System.out.println("Please enter a number: ");
        n = in.nextInt();
        
        System.out.println(toBinary(n));
        
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("Greatest Common Divisor");
        System.out.println("=================================================");
        System.out.println("");
        
        int a;
        int b;
        
        System.out.println("Please pick the first number you wish to find the"
                + " GCD: ");
        int firstNum = in.nextInt();
        
        System.out.println("please pick the second number you wish to find the"
                + " GCD: ");
        int secondNum = in.nextInt();
        
        if((firstNum > secondNum) || (firstNum == secondNum)){
            a = firstNum;
            b = secondNum;
        }else{
            a = secondNum;
            b = firstNum;
        }       
        System.out.println(gcd(a,b));
               
    }
    
    public static String toBinary(int n){
        if(n <= 1){
            return String.valueOf(n);
        }
        return (toBinary(n/2) + String.valueOf(n%2));
    }
    
    public static int gcd(int a, int b){
        if(a == 0 || b == 0){
            return a+b;
        }else{
            return gcd(b, a%b);
        }
    }
    
}
