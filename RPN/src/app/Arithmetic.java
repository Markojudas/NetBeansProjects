
package app;

import java.util.Stack;

public class Arithmetic {
    
    public String inFix;
    
    public Arithmetic(String inFix){
        this.inFix = inFix;
        
        isBalanced(inFix);       
    }
    
    public static boolean isBalanced(String inFix){
        
        boolean isBalanced = false;
        
        Stack stack = new Stack();
        
        for(int i=0; i < inFix.length(); i++){
            char exp = inFix.charAt(i);

        }
    }
    
}
