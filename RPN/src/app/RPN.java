package app;
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
                        "2 + ( - 3 * 5)",
                        "( ( 2 + 3 ) * 5 ) * 8",
                        "5 * 10 + ( 15 - 20) ) - 25",
                        "5 + ( 5 * 10 + ( 15 - 20 ) - 25 ) * 9"
                        };
        //declaring & initiating a counter for output purposes
        int counter =0;
        
        //traversing through the array to start evaluating each String
        //creating an instance of the Arithmetic class for each String
        for(int i = 0; i < s.length; i++){
            Arithmetic a = new Arithmetic(s[i]);
            counter++;
            
            if(a.isBalanced(s[i])){
                System.out.println(counter + ". Expression " + s[i] + " is Balanced");
                System.out.println("\tThe postfix expression thus far is: " + a.postFixExpression(s[i]) + "\n");
            }else{
                System.out.println(counter + ". Expression is not Balanced\n");
            }
        }
        
        
    }
    
}
