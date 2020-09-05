package app;
//Arithmetic class where the 3 methods are implemented 

import java.util.Stack;

public class Arithmetic {
    
    private String inFix;
    private String postFix;
    
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
    
    public void postFixExpression(String inFix){
        //Method to convert the balanced infix expression into postfix
        //method is accepting the String and then creating a string array to 
        //break the string by the space to keep in account the double digit numbers
        
        Stack<String> stack = new Stack<>();
        postFix = "";
        String[] cutStr = inFix.split(" ");
        
        //enhance for-loop to traverse through string array
        for (String element : cutStr) {           
            /*
             *I am using the equals() method to hit the operands/numbers
             *if the element in the array is ( it will be pushed into the stack
             *if the element in the array is ) and the stack is not empty it will pop the stack
             *if the stack is not empty it will pop the stack; if the element popped is NOT (
             *it will be appended into the postFix string.
             */          
            if(!element.equals("+") && !element.equals("-") && !element.equals("*") 
                    && !element.equals("/") && !element.equals("%")
                    && !element.equals("(") && !element.equals(")"))
            {
                postFix += element + " ";
            }else if(element.equals("(")){
                stack.push(element);
            }else if(element.equals(")")){
                while(!stack.isEmpty()){
                    String t = stack.pop();
                    if(!t.equals("(")){
                        postFix += t + " ";
                    }else{
                        break;
                    }
                }            
            }           
            /*
             *If the element in the array is any of the operators and the stack
             *is empty it will be pushed into the array
             *if the stack is not empty it will pop the stack
             *if the element element popped is ( it will be pushed into the stack
             *if the element poppped is an operand it will be compared precedence
             *with the element from the array; using the precedence() method.
             *if the element form the array is of higher or equal it will be pushed
             */
            else if(element.equals("+") || element.equals("-") || element.equals("*") 
                    || element.equals("/") || element.equals("%")){
                
                if(stack.isEmpty()){
                    stack.push(element);
                }else{
                    while(!stack.isEmpty()){
                        String t = stack.pop();
                        if(t.equals("(")){
                            stack.push(t);
                            break;
                        }else if(t.equals("+") || t.equals("-") || t.equals("*")
                                || t.equals("/") || t.equals("%")){
                            if(precedence(t) < precedence(element)){
                                stack.push(t);
                                break;
                            }else{
                                postFix += t + " ";
                            }
                        }
                    }
                    stack.push(element);
                }
            }
        }
        //if the stack is not empty it will pop all the elements into the postFix string
        while(!stack.isEmpty()){
            postFix += stack.pop() + " ";
        }       
    }
    
    public int evaluateRPN(String postFix){
        Stack<Integer> result = new Stack<>();
        String[] cutStr = postFix.split(" ");
        int t1 = 0;
        int t2 = 0;
        
        for (String x : cutStr) {
            if(!x.equals("+") && !x.equals("-") && !x.equals("*") && !x.equals("/")
                    && !x.equals("%")){
                result.push(Integer.parseInt(x));
            }else{
                t1 = result.pop();
                t2 = result.pop();
                switch (x) {
                    case "+":
                        result.push(t2 + t1);
                        break;
                    case "-":
                        result.push(t2 - t1);
                        break;
                    case "*":
                        result.push(t2 * t1);
                        break;
                    case "/":
                        result.push(t2 /  t1);
                        break;
                    case "%":
                        result.push(t2 % t1);
                        break;
                    default:
                        break;
                }
            }           
        }
        return result.pop(); 
    }
    
    public static int precedence(String x){       
        //method returning either 1 or 2 setting the precedence of the operators
        
        if(x.equals("+")|| x.equals("-")){
            return 1;
        }else
            return 2;
    }
    
    public String getPostFix(){
        return postFix;
    }            
}
