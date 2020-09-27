/*
ASSIGNMENT 1

Programmer: Jose R Hernandez
Course: COP 3530 - Data Structures
Section: RVC 1208
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
        String[] s =    {"5 + ) * ( 2",
                        "2 + ( -3 * 5 )",
                        "( ( 2 + 3 ) * 5 ) * 8",
                        "5 * 10 + ( 15 - 20 ) ) - 25",
                        "5 + ( 5 * 10 + ( 15 - 20 ) - 25 ) * 9",
                        "10 + 30 * 5",
                        "( 30 * ( 100 - 4 ) + ( 20 / 20 - 5 ) + 65",
                        "( 50 + 100 ) / ( ( 15 - 20 ) * 25 )"
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
                System.out.println(counter + ". Expression " + expression + " is balanced");
                
                a.postFixExpression(expression);
                String postFix = a.getPostFix();              
                System.out.println("\tThe postfix expression is: " + postFix);
                a.evaluateRPN(postFix);
                
                //If the stack is empty or has more than 1 operand then the result is unreliable
                //Therefore the Stack should be size 1 as in having 1 element and if so then it gets popped
                if(a.getResult().size() == 1){
                    System.out.println("\tThe result of the expression: " + a.getResult().pop());
                    System.out.println("\tThe result is reliable\n");
                }else{
                    System.out.println("The result is unreliable\n");
                }         
            }else{
                System.out.println(counter + ". Expression " + expression + " is not balanced\n");
            }
            
            System.out.println("====================================================================\n");
        }                
    }    
}
