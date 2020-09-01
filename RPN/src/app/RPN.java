package app;

import java.util.Arrays;

public class RPN {

    public static void main(String[] args) {
        
        String s[] =    {"5 + ) * (2",
                        "2 + (-3 * 5)",
                        "((2 + 3) * 5) * 8",
                        "5 * 10 + (15 - 20)) - 25",
                        "5 + (5 * 10 + (15 - 20) - 25) * 9"
                        };
        
        for(int i = 0; i < s.length; i++){
            Arithmetic a = new Arithmetic(s[i]);
            
            if(a.isBalanced(s[i])){
                System.out.println("Expression " + s[i] + " is Balanced\n");
            }else{
                System.out.println("Expression is not Balanced\n");
            }
        }
        
    }
    
}
