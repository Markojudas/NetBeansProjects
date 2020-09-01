
package app;
import java.util.Arrays;

public class Fibonacci {
    
    static int x = -2;
    static int y = -1;
    static int z = 9;

    public static void main(String[] args) {
        

        for (int n = 1; n <=20; n++){
            if(n != 20){
                System.out.print(fib(n) + ", ");
            }else{
                System.out.println(fib(n));
            }

        }
 }
    
    public static int fib(int n){
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n == 3) return 2;
        
        return x*fib(n-1) + y*fib(n-2) + z*fib(n-3);
    }
    
}
