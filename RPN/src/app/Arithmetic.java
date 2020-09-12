package app;
//Arithmetic class where the 3 methods are implemented 

import java.util.Stack;

public class Arithmetic {
    
    //instance varibles
    
    private String inFix;
    private String postFix;
    private Stack<Integer> result;
    
    //constructor that calls the isBalanced() method to determine
    // if the paranthesis are balanced
    public Arithmetic(String inFix){
        this.inFix = inFix;             
    }
    
    public boolean isBalanced(String inFix){
        
        boolean isBalanced = false;
        
        //Creating a stack to help with checking whether it is balanced or not
        Stack<Character> stack = new Stack<>();
        
        //Reading the string one character at a time
        //Creating another string storing each character of the input string at the time
        //if the string doesn't have any parenthesis then the expression is already balanced
        if(inFix.contains("(") || inFix.contains(")")){    
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
            if(!stack.isEmpty()){ //if the stack is not at the end of the reading then it is not balanced
                isBalanced = false;
            }
        }
        }else{
            isBalanced = true;
        }
        return isBalanced;
    }
    
    public void postFixExpression(String inFix){
        //Method to convert the balanced infix expression into postfix
        //method is accepting the String and then creating a string array to 
        //break the string by the space to keep in account the double digit numbers
        //using the cutStr() method
        
        Stack<String> stack = new Stack<>();
        postFix = "";
        String[] cutStr = cutStr(inFix);
        
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
    
    
    
    public void evaluateRPN(String postFix){       
        /*
        Method to evalute the postFix expression
        It accepts the postFix String and then calls the Cut String method to
        create a String array with each operand and operator ignoring the spaces.
        Used to keep in account the double digit numbers.
        */
        result = new Stack<>();
        String[] cutStr = cutStr(postFix);
        
        int t1;
        int t2;
        
        /*
        Traversing through the String array.
        If the token is not one of the operators then it is a number.
        If the token is a number then it's converted into a int/Integer by using the parseInt method
        then it is placed into the result Stack.
        If the token is an operator it poops the two upper most elements on the Stack
        Then it performs the arithmetic operation depending on the operator and its precedence.
        */
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
    }
    
    public static int precedence(String x){       
        //method returning either 1 or 2 setting the precedence of the operators
        
        if(x.equals("+")|| x.equals("-")){
            return 1;
        }else
            return 2;
    }
    
    public String getPostFix(){
        //Method to access the postFix varible from another class        
        return postFix;
    }
    
    public Stack<Integer> getResult(){
        return result;
    }
    
    public static String[] cutStr(String x){
        //Method to split the String to ignore the spaces
        //used to keep in account numbers of more than single digit.        
        String[] cutStr = x.split(" ");
        
        return cutStr;
    }
}
