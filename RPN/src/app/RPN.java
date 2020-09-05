/*
ASSIGNMNET 1

Programmer: Jose R Hernandez
Course: Data Structures 
Term: Fall 2020
PantherID: 1398700

*/

package app;
/*
This program will use the concept of stack.
It will first determine if a given arithmatic expression is properly formed
Then will convert the infixed expression to postfix
Finally it will then evalutate the postfixed expression and print the results
*/
public class RPN {

    public static void main(String[] args) {
        
        //Array of Strings with the given arithmetic expression
        String s[] =    {"5 + ) * ( 2",
                        "2 + ( -3 * 5 )",
                        "( ( 2 + 3 ) * 5 ) * 8",
                        "5 * 10 + ( 15 - 20) ) - 25",
                        "5 + ( 5 * 10 + ( 15 - 20 ) - 25 ) * 9",
                        };
        //declaring & initiating a counter for output purposes
        int counter =0;
                
        //traversing through the array to start evaluating each String
        //creating an instance of the Arithmetic class for each String
        for (String expression : s) {
            Arithmetic a = new Arithmetic(expression);
            counter++;
            
            /*
            If the expression is balanced then it will convert the expression
            into postFix and evaluate the postFix expression, printing the result of both
            conversation and evaluation.
            Otherwise, it will print out that it is not balanced
            */
            if (a.isBalanced(expression)) {
                System.out.println(counter + ". Expression " + expression + " is Balanced");
                
                a.postFixExpression(expression);
                String postFix = a.getPostFix();
                int result = a.evaluateRPN(postFix);
                
                System.out.println("\tThe postfix expression is: " + postFix);
                System.out.println("\tThe answer to the expression is: " + result + "\n");
                
            } else {
                System.out.println(counter + ". Expression is not Balanced\n");
            }
        }                
    }    
}
