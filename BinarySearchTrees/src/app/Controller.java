package app;


public class Controller {


    public static void main(String[] args) {
        
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        
        System.out.println("=================================================");
        System.out.println("IN ORDER TRAVERSAL // DEPTH FIRST");
        System.out.println("=================================================");
        System.out.println("");
        
        intTree.traverseInOrder();
        
        System.out.println("");
        
        System.out.println("\n=================================================");
        System.out.println("LEVEL ORDER TRAVERSAL // BREADTH FIRST");
        System.out.println("=================================================\n");
        intTree.levelOrderTraversal();
        
        System.out.println("");

        System.out.println("\n=================================================");
        System.out.println("PRE ORDER TRAVERSAL // DEPTH FIRST");
        System.out.println("=================================================\n");
        
        intTree.traversePreOrder();
        
        System.out.println("");

        System.out.println("\n=================================================");
        System.out.println("POST ORDER TRAVERSAL // DEPTH FIRST");
        System.out.println("=================================================\n");
        intTree.traversePostOrder();
        
        System.out.println("");        
       
    }
    
}
