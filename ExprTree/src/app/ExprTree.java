package app;
import java.util.Scanner;

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
        System.out.println("=================================================");
        System.out.println("INFIX EXPRESSION:");
        System.out.println("=================================================");
        if (root != null){
            root.traverseInOrder();
        }
        System.out.println("");
    }
    
    public void traversePostOrder(){
        System.out.println("=================================================");
        System.out.println("POSTFIX EXPRESSION:");
        System.out.println("=================================================");       
        if (root != null){
            root.traversePostOrder();
        }
        System.out.println("");
    }
    
    
    
}
