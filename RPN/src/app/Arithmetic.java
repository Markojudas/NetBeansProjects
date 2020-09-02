package app;
//Arithmetic class where the 3 methods are implemented 

import java.util.Stack;

public class Arithmetic {
    
    public String inFix;
    
    //constructor that calls the isBalanced() method to determine
    // if the paranthesis are balanced
    public Arithmetic(String inFix){
        this.inFix = inFix;
              
    }
    
    public boolean isBalanced(String inFix){
        
        boolean isBalanced = false;
        
        //Creating a stack to help with checking whether it is balanced or not
        Stack<Character> stack = new Stack<>();
        
        //reading each string one character at a time from left to right
        for(int i=0; i < inFix.length(); i++){
            char exp = inFix.charAt(i);
            
            //if statements to test the characters
            //it will push onto the stack a left paranthesis "(" 
            //it will then pop the stack once a right parenthesis ")" is encountered
            //it will determine whether the expression is properly formed.
            if(exp == '('){
                stack.push(exp);
            }else if(exp == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                    isBalanced = true;
                }else{
                    isBalanced = false;
                }                  
            }               
        }
        return isBalanced;
    }
    
    public String postFixExpression(String inFix){
        Stack<Character> charStack = new Stack<>();
        String postFix = "";
        
        for(int i=0; i < inFix.length(); i++){
            char exp = inFix.charAt(i);
            
            if(Character.isDigit(exp)){
                postFix += exp;
            }else if(exp == '('){
                charStack.push(exp);
            }else if(exp == ')' && !charStack.isEmpty()){                
                while(charStack.pop() != '(')
                    postFix += charStack.pop();                
            }
        }
        return postFix;
    }
        
        
    
}
