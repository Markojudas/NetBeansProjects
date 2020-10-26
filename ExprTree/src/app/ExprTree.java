package app;

import java.util.ArrayList;
import java.util.Stack;

public class ExprTree {
    
    public Node root;
    public String expression;
    public String postFix = "";

    
    public ExprTree(String _expression){
        expression = _expression;
        setRoot();
    }
    
    //this is the same method as project 1 to determine if the expression is balanced
    public boolean isBalanced(String inFix){
        
        boolean isBalanced = false;
        
        Stack<Character> stack = new Stack<>();
       

        if(inFix.contains("(") || inFix.contains(")")){    
        for(int i=0; i < inFix.length(); i++){
            char exp = inFix.charAt(i);
            

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
            if(!stack.isEmpty()){
                isBalanced = false;
            }
        }
        }else{
            isBalanced = true;
        }
        return isBalanced;
    }
    
    //this method starts building the tree
    //it calls the buildTree, first taking in consideration the blank spaces
    //the root of the tree will have all its children once done
    
    public void setRoot(){
        root = buildTree(null, expression.replace(" ", "")); //using this to take care of white spaces
    }
    
    //this method populates the tree nodes
    private Node buildTree(Node node, String currentExpression){
        
        if (currentExpression.isEmpty()){
            return null;
        }
        
        //here I am selecting the index of the root where to break the string into left and right
        int index = getIndex(currentExpression);
        String leftSide = "";
        String  rightSide = "";
        String current;
        boolean isOperator = false;
        
        //here it breaks the string with left and right depending on the root
        if (index != -1){
            current = currentExpression.substring(index, index + 1);
            isOperator = true;
            leftSide = currentExpression.substring(0, index);
            rightSide = currentExpression.substring(index + 1);
        }else{
            current = currentExpression;
        }
        
        //here I populate the left and right nodes
        if (currentExpression.length() > 0){
            if (!current.isEmpty()){
                Node nodeToAdd = new Node(current.replace("(", "").replace(")", "")); //taking care of the parentheses
                
                nodeToAdd.isOperator = isOperator;
                node = nodeToAdd;
                node.left = buildTree(node.left, leftSide);
                node.right = buildTree(node.right, rightSide);
            }else{
                if (leftSide.length() > 0){
                    node = new Node(rightSide.replace("(", "").replace(")", ""));                  
                }
                else if(rightSide.length() > 0){
                    node = new Node(rightSide.replace("(", "").replace(")", ""));
                }
                node.left = buildTree(node.left, leftSide);
                node.right = buildTree(node.right, rightSide);
            }            
        }else{
            return null;
        }
        
        return node;
    }
    
    //this method sets the index where to break the string and set left and right
    //it determines the index for the last operator with the least precedence 
    private int getIndex(String expression){
        String plusMinus = "+-";
        String timesDiv = "*/";
        
        //creating an Arraylist to keep track of the operators
        //creating a stack to keep track of the operands
        ArrayList<ExpOper> operators = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        
        //traversing the string 
        for (int i = 0; i < expression.length(); i++){
            String item = expression.substring(i, i + 1);
            if (item.equals("(")){
                stack.push(item);
            }
            else{
                if (item.equals(")") && stack.size() > 0){
                    stack.pop();
                }
                else if(plusMinus.contains(item) || timesDiv.contains(item)){
                    operators.add(new ExpOper(i, item, stack.size()));
                }
            }
        }
        
        int indexToUse = -1;
        
        if(operators.size() > 0){
            int additionIndex = -1;
            int subtractionIndex = -1;
            int multiplicationIndex = -1;
            int divisionIndex = -1;
            int maxParenLvl = maxIndex(operators);
            
            for (int i = 0; i <= maxParenLvl; i++){
                for (ExpOper op : operators){
                    
                    //different levels depending on the parentheses. 
                    if(op.parenLvl == i){
                        switch (op.Operator){
                            
                            case "+":
                                additionIndex = op.index;
                                break;
                            case "-":
                                subtractionIndex = op.index;
                                break;
                            case "*":
                                multiplicationIndex = op.index;
                                break;
                            case "/":
                                divisionIndex = op.index;
                                break;
                            default:
                                break;
                        }
                    }
                }
                //making sure we use the last operator (higher index)
                indexToUse = additionIndex > subtractionIndex ? additionIndex : subtractionIndex;
                
                if (indexToUse == -1){
                    indexToUse = multiplicationIndex > divisionIndex ? multiplicationIndex : divisionIndex;
                }
                
                if (indexToUse != -1){
                    break;
                }
            }
        }
        return indexToUse;
    }
    
    //method to get the postFix expression
    public String getPostFixed(){
        
        traversePostOrder(root);
        
        return postFix;        
    }
    
    //reading the tree in post Order
    private void traversePostOrder(Node node){
        if(node == null){
            return;
        }
        
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        postFix += node.value + " ";
    }
    
    //method to evaluate the tree
    public String evaluteExpression(){
        
        return String.valueOf(evaluateNodes(root));
       
    }
    
    //traversing through the tree doing all the arithmetic
    private int evaluateNodes(Node node){
        
        int result;
        int operand1;
        int operand2;
        
        if (node == null){
            result = 0;
        }
        else{
            Node temp = node;
            
            if(node.isOperator){
                
                operand1 = evaluateNodes(node.left);
                operand2 = evaluateNodes(node.right);
                result = solveArith(temp.value.charAt(0), operand1, operand2);
            }else{
                result = Integer.parseInt(temp.value);
            }
        }
        return result;                
    }
    
    //method doing the math and returning the result
    private int solveArith(char op, int operand1, int operand2){
        
        int result;
        
        if (op == '+'){
            result = operand1 + operand2;
        }
        else if (op == '-'){
            result = operand1 - operand2;
        }
        else if (op == '*'){
            result = operand1 * operand2;
        }
        else{
            result = operand1 / operand2;
        }
        
        return result;
    }
    
    //getting the max index
    private int maxIndex(ArrayList<ExpOper> operators){
        int max = 0;
        
        for (ExpOper item : operators){
            if(item.parenLvl > max){
                max = item.parenLvl;
            }
        }
        return max;
    }
    
    
    
    
    

    
    
}
