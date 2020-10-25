package app;

public class Node {
    
    private char node;
    private Node left;
    private Node right;
    

    public char getData() {
        return node;
    }

    public void setData(char data) {
        this.node = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    public void traverseInOrder(){
        
        if (left != null){
            System.out.print("( ");
            left.traverseInOrder();
        }
        System.out.print(node + " ");
        if (right != null){
            right.traverseInOrder();
            System.out.print(") ");
        }
    }
    
    public void traversePostOrder(){
        
        if (left != null){
            left.traversePostOrder();
        }
        if (right != null){
            right.traversePostOrder();
        }
        System.out.print(node + " ");        
    }
   
    
}
