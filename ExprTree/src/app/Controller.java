/*
Author: Jose R Hernandez
Assignment: 2

Course: Data Structures; Fall 2020
instructor: Joslyn Smith

This program is repeating Assignment 1 where I am converting a inFix expression 
and converting it into postFix or RPN using stack. Here we are using the
Data Structure Binary Tree, or Expression Tree.

We first evaluate the Expression to see if it is balanced in respect to the
parentheses. If the expression is balanced it will construct a binary tree.

Once the tree is built, it will traverse the tree in post order to get the postFix expression.
It will also then evaluate the expression.

*/

package app;

public class Controller {

    public static void main(String[] args) {
        
       //String[] expressions = {"2 + (3 * 5) + 9"};
        
       
        String[] expressions = {" 5 + ) * ( 2 ",
                        "2 + ( -3 * 5 )",
                        "( ( 2 + 3 ) * 5 ) * 8",
                        "5 * 10 + ( 15 - 20 ) ) - 25",
                        "5 + ( 5 * 10 + ( 15 - 20 ) - 25 ) * 9",
                        "10 + 30 * 5",
                        "( 30 * ( 100 - 4 ) + ( 20 / 20 - 5 ) + 65",
                        "( 50 + 100 ) / ( ( 15 - 20 ) * 25 )"
                        };
                        
        
        int counter = 0;
        
        for (String expression : expressions) {
            ExpressionTree tree = new ExpressionTree(expression);
            counter++;
            
            
            if(tree.isBalanced(expression)){
                
                tree.makeTree();
                  
                System.out.println("======================================================================");
                System.out.println("Expression #: " + counter);
                System.out.println("======================================================================");
                System.out.println("");
                System.out.println("Original: " + expression);
                System.out.println("Post Order: " + tree.getPostFixed());
                System.out.println("Result: " + tree.evaluteExpression() + "\n");
            }
            else{
                System.out.println("======================================================================");
                System.out.println("Expression #: " + counter + " is not balanced\n");
                System.out.println("Original: " + expression);
                System.out.println("======================================================================\n");
            }
        }
    }    
}
