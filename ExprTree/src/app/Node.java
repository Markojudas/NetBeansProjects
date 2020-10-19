package app;

public class Node {
    
    private char data;
    private Node left;
    private Node right;
    

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
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
        System.out.print(data + " ");
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
        System.out.print(data + " ");        
    }
   
    
}
