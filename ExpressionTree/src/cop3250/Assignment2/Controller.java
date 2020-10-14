package cop3250.Assignment2;

public class Controller {

    public static void main(String[] args) {
        
        String expression = "2 + ( 3 * 5 ) + 9";
        
        //answer: -4
        
        BinaryTree expressionTree = new BinaryTree(expression);
        
        expressionTree.traverseInOrder();
                

        
    }
    
}
