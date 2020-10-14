package cop3250.Assignment2;

public class BinaryTreeNode {
    
    public String data;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;

    public BinaryTreeNode(String data) {
        this.data = data;
    }
    
    public void insertLeft(String value){
        if (value == data){
            return;
        }
        if (leftChild == null){
            leftChild = new BinaryTreeNode(value);
        }
        else{
            leftChild.insertLeft(value);
        }
            
    }
    
    public void insertRight(String value){
        if (value == data){
            return;
        }
        if (rightChild == null){
            rightChild = new BinaryTreeNode(value);
        }
        else{
            rightChild.insertRight(value);
        }           
    }

    public void traverseInOrder(){
        if (leftChild != null){
            leftChild.traverseInOrder();
        }
        //System.out.print(data + ", ");
        if (rightChild != null){
            rightChild.traverseInOrder();
        }
        System.out.print(data + ", ");

        
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }    
}
