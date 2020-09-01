package test;

import java.util.Stack;

public class app {

    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        
        int value = fib(5, stack);
        
        System.out.println(stack);
        

    }
    
    public static int fib(int n, Stack<Integer> stack){
        stack.push(n);
        
        if(n == 1) return 1;
        if(n == 2) return 2;
            
        return fib(n-1, stack) + fib(n-2, stack);
    }
    
}
