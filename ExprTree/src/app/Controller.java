package app;

public class Controller {

    public static void main(String[] args) {
        
        //String expression = "((2 + 3) * (2 + 4))";
        
        String[] expressions = {"( 5 + ) * ( 2 )",
                        "( 2 + ( -3 * 5 ) )",
                        "( ( ( 2 + 3 ) * 5 ) * 8 )",
                        "( 5 * 10 + ( 15 - 20 ) ) - 25 )",
                        "( 5 + ( 5 * 10 + ( 15 - 20 ) - 25 ) * 9 )",
                        "( 10 + 30 * 5 )",
                        "( ( 30 * ( 100 - 4 ) + ( 20 / 20 - 5 ) + 65 )",
                        "( ( 50 + 100 ) / ( ( 15 - 20 ) * 25 ) )"
                        };
        //System.out.println("ENTER EXPRESSION");
        
        int counter = 0;
        
        for(int i = 0; i < expressions.length; i ++){
            String expression = expressions[i];
            
            ExprTree tree = new ExprTree(expression);
            counter++;
            
            
            if(tree.isBalanced(expression)){
            tree.constructTree();
            
                System.out.println("======================================================================");
                System.out.println("Expression #:" + counter);
                System.out.println("======================================================================");
                System.out.println("");
                System.out.print("Original: ");
                tree.traverseInOrder();
                System.out.println("");
                System.out.print("Post Order: ");
                tree.traversePostOrder();
                System.out.println("");
            }
            else{
                System.out.println("==================================================================");
                System.out.println("Expression #:" + counter + " is not balanced");
                System.out.println("==================================================================");
                System.out.println("");
            }
        }
        
        //ExprTree tree = new ExprTree(expression);
        //tree.constructTree();
        
        //tree.traverseInOrder();
        //System.out.println("");
        //tree.traversePostOrder();
    }
    
}
