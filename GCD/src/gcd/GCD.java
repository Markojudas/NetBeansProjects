/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

/**
 *
 * @author josrh
 */
public class GCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("the GCD of 1989 & 1590 is: " + gcd(50, 15));
        
        System.out.println("============================================\n");
        
        System.out.println(pow(4,4));
        
    }
    
    public static long gcd(long m, long n){
        
        while(n != 0){
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
    
    public static long pow (long x, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(isEven(n))
            return pow(x * x, n/2);
        else
            return pow(x * x, n /2) * x;
    }
    
    public static boolean isEven(long n){
        
        boolean isEven = false;
        
        isEven = n % 2 == 0;
        
        return isEven;
    }
    
}
