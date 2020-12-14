/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author josrh
 */
public class TreeNode {
    
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public void insert(int value){
        if (value == data){ //checks for duplicate
            return;
        }
        
        //populates the tree checking 
        if (value < data){
            if (leftChild == null){
                leftChild = new TreeNode(value);
            }else{
                leftChild.insert(value);
            }
        }else{
            if (rightChild == null){
                rightChild = new TreeNode(value);
            }else{
                rightChild.insert(value);
            }
        }
    }

    public void traverseInOrder(){
        if (leftChild != null){
            leftChild.traverseInOrder();
        }
           System.out.print(data + ", ");
        if (rightChild != null){
            rightChild.traverseInOrder();
        }
    }
    
    public void traversePreOrder(){
        
        System.out.print(data + ", ");
        
        if (leftChild != null){
            leftChild.traversePreOrder();
        }
        if (rightChild != null){
            rightChild.traversePreOrder();
        }
    }
    
    public void traversePostOrder(){
        
        if (leftChild != null){
            leftChild.traversePostOrder();
        }
        if (rightChild != null){
            rightChild.traversePostOrder();
        }
        
        System.out.print(data + ", ");
        
    }
    
    //implementing a Depth-First Traversal of the tree
    //This prints in level ordered
    //it uses a queue since there is no link between left and right child
    //we send the root or node of the tree. We add it to the queue.
    //while the queue is not empty we create a pointer of the front of the queue (current)
    //and remove it from the queue (poll). We check of the "current" has a left child
    //if so, we add it to the queue and we do the same to the right child.
    //at this point the while loops back checking and removing the front of the queue
    //until the queue is finally empty.
    public void levelOrderTraversal(TreeNode root){
        
        Queue<TreeNode> s = new LinkedList<>();
        
        s.add(root);
        
        while(!s.isEmpty()){
            TreeNode current = s.peek();
            s.poll();
            if(s.isEmpty() && current.leftChild == null && current.rightChild == null){
                System.out.print(current.data + ". ");               
            }
            else{
                System.out.print(current.data + ", ");
            }
             
            if(current.leftChild != null){
                s.add(current.leftChild);
            }
            if(current.rightChild != null){
                s.add(current.rightChild);
            }
        }      
    }

    public TreeNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
}
