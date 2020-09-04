package app;

import java.util.Arrays;

/*
This program will use the concept of stack.
It will first determine if a given arithmatic expression is properly formed
Then will convert the infixed expression to postfix
Finally it will then evalutate the postfixed expression and print the results
*/
public class RPN {

    public static void main(String[] args) {
        
        //Array of Strings storing the given arithmetic expression
        String s[] =    {"5 + ) * ( 2",
                        "2 + ( - 3 * 5 )",
                        "( ( 2 + 3 ) * 5 ) * 8",
                        "5 * 10 + ( 15 - 20) ) - 25",
                        "5 + ( 5 * 10 + ( 15 - 20 ) - 25 ) * 9"
                        };
        //declaring & initiating a counter for output purposes
        int counter =0;
                
        //traversing through the array to start evaluating each String
        //creating an instance of the Arithmetic class for each String
        for (String expression : s) {
            Arithmetic a = new Arithmetic(expression);
            counter++;
            
            if (a.isBalanced(expression)) {
                System.out.println(counter + ". Expression " + expression + " is Balanced");
                System.out.println("\tThe postfix expression now is: " + a.postFixExpression(expression) + "\n");
            } else {
                System.out.println(counter + ". Expression is not Balanced\n");
            }

            //System.out.println(Arrays.toString(a.postFixExpression(expression)));
        }
        
        
    }
    
}
