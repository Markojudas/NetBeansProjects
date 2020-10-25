package app;
import java.util.Scanner;
import java.util.Stack;

public class ExprTree {
    
    private Node root;
    private Scanner in;
   
    
    public ExprTree(String expression){
        root = null;
        in = new Scanner(expression);
    }
    
    public void constructTree(){
        root = makeTree();
    }
    
    public boolean isBalanced(String inFix){
        
        boolean isBalanced = false;
        
        //Creating a stack to help with checking whether it is balanced or not
        Stack<Character> stack = new Stack<>();
        
        //Reading the string one character at a time
        //Creating another string storing each character of the input string at the time
        //if the string doesn't have any parenthesis then the expression is already balanced
        if(inFix.contains("(") || inFix.contains(")")){    
        for(int i=0; i < inFix.length(); i++){
            char exp = inFix.charAt(i);
            
            //if statements to test the characters
            //it will push onto the stack a left paranthesis "(" 
            //it will then pop the stack once a right parenthesis ")" is encountered
            //it will determine whether the expression is properly formed.
            if(exp == '('){
                stack.push(exp);
            }else if(exp == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                    isBalanced = true;
                }else{
                    isBalanced = false;
                }                  
            }
            if(!stack.isEmpty()){ //if the stack is not at the end of the reading then it is not balanced
                isBalanced = false;
            }
        }
        }else{
            isBalanced = true;
        }
        return isBalanced;
    }
    
    
    public Node makeTree(){
       Node n = new Node();
        
        //for the non-whitespaces 
        char ch = in.findInLine("(\\S)").charAt(0);
        //System.out.println("CH : " + ch);
        
        if((ch != '(') && (ch != ')')){            
            //this  will be the leaf nodes
            n.setData(ch);
            n.setLeft(null);
            n.setRight(null);                      
        }else if (ch == '('){
            n.setLeft(makeTree());
            n.setData(in.findInLine("(\\S)").charAt(0));
            n.setRight(makeTree());
            ch = in.findInLine("(\\S)").charAt(0);           
        }
        return n;            
    }
    
    public void traverseInOrder(){
        if (root != null){
            root.traverseInOrder();
        }
        System.out.println("");
    }
    
    public void traversePostOrder(){       
        if (root != null){
            root.traversePostOrder();
        }
        System.out.println("");
    }
    
    
    
}
