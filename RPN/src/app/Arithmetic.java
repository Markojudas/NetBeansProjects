
package app;

import java.util.Stack;

public class Arithmetic {
    
    public String inFix;
    
    public Arithmetic(String inFix){
        this.inFix = inFix;
        
        isBalanced(inFix);       
    }
    
    public boolean isBalanced(String inFix){
        
        boolean isBalanced = false;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i < inFix.length(); i++){
            char exp = inFix.charAt(i);
            
            if(exp == '('){
                stack.push(exp);
            }else if(exp == ')' && !stack.isEmpty()) {
                stack.pop();
            }          
        }
        
        isBalanced = stack.isEmpty();
        return isBalanced;
    }
        
        
    
}
