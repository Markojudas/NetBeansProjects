package app;

public class Controller {

    public static void main(String[] args) {
        
        String expression = "((2 + 3) * (2 + 4))";
        
        //System.out.println("ENTER EXPRESSION");
        
        ExprTree tree = new ExprTree(expression);
        tree.constructTree();
        
        tree.traverseInOrder();
        System.out.println("");
        tree.traversePostOrder();
    }
    
}
