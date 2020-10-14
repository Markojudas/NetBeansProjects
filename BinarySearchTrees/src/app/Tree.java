/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author josrh
 */
public class Tree {
    
    private TreeNode root;

    public void insert (int value){
        if (root == null){
            root = new TreeNode(value);
        }else{
            root.insert(value);
        }
    }

    public void traverseInOrder(){
        if (root != null){
            root.traverseInOrder();
        }
    }

    
}
