package app;
//Arithmetic class where the 3 methods are implemented 

import java.util.Arrays;
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
        Stack<String> charStack = new Stack<>();
        String postFix = "";
        String[] cutStr = inFix.split(" ");
        //char e[] = inFix.toCharArray(); -> need to change the loop to e.length
        
        for (String element : cutStr) {
            if(!element.equals("+") && !element.equals("-") && !element.equals("*") && !element.equals("/") && !element.equals("%")
                    && !element.equals("(") && !element.equals(")"))
            {
                postFix += element;
            }else if(element.equals("(")){
                charStack.push(element);
            }else if(element.equals(")")){
                while(!charStack.isEmpty()){
                    String t = charStack.pop();
                    if(!t.equals("(")){
                        postFix += t;
                    }else{
                        break;
                    }
                }
            }else if(element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/") || element.equals("%")){
                if(charStack.isEmpty()){
                    charStack.push(element);
                }else{
                    while(!charStack.isEmpty()){
                        String t = charStack.pop();
                        if(t.equals("(")){
                            charStack.push(t);
                            break;
                        }else if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/") || t.equals("%")){
                            if(precedence(t) < precedence(element)){
                                charStack.push(t);
                                break;
                            }else{
                                postFix += t;
                            }
                        }
                    }
                    charStack.push(element);
                }
            }
        }
        while(!charStack.isEmpty()){
            postFix += charStack.pop();
        }
        return postFix;
        
    }
    
  /*  
    public String postFixExpression(String inFix){
        Stack<Character> charStack = new Stack<>();
        String postFix = "";
        //String x[] = inFix.split(" ");
        //char e[] = inFix.toCharArray(); -> need to change the loop to e.length
        
        for(int i=0; i < inFix.length(); i++){
            char x = inFix.charAt(i);
            
            if(Character.isDigit(x)){
               postFix += x;
            }else if(x == '('){
                charStack.push(x);
            }else if(x == ')'){
                while(!charStack.isEmpty()){
                    char t = charStack.pop();
                    if(t != '('){
                        postFix += t;
                    }else{
                        break;
                    }
                }
            }else if(x == '+' || x == '-' || x == '*' || x == '/' || x == '%'){
                if(charStack.isEmpty()){
                    charStack.push(x);
                }else{
                    while(!charStack.isEmpty()){
                        char t = charStack.pop();
                        if(t == '('){
                            charStack.push(t);
                            break;
                        }else if(t == '+' || t == '-' || t == '*' || x == '/' || x == '%'){
                            if(precedence(t) < precedence(x)){
                                charStack.push(t);
                                break;
                            }else{
                                postFix += t;
                            }
                        }
                    }
                    charStack.push(x);
                }
            }
        }
        while(!charStack.isEmpty()){
            postFix += charStack.pop();
        }
        return postFix;
    }
    */
    public static int precedence(String x){
        
        if(x.equals("+")|| x.equals("-")){
            return 1;
        }else
            return 2;
    } 
        
        
    
}
