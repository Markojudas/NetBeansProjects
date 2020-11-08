package app;

import java.util.ArrayList;
import java.util.Stack;

public class ExpressionTree {
    
    public Node root;
    public String expression;
    public String postFix = "";

    
    public ExpressionTree(String _expression){
        expression = _expression;
        //setRoot();
    }
    
    //this is the same method as project 1 to determine if the expression is balanced
    //i am using the stack to push when we encounter a "("
    //when we encounter a ")" and the stack is not empty we pop the stack
    //if we encounter a ")" and the stack IS empty the expression is not balanced
    //if we end reading the expression and stack is NOT empty, the expression is not balanced
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
    //it calls the setTreeNodes to start populating the nodes and leaves, first taking in consideration the blank spaces
    //the root of the tree will have all its children once done
    
    public void makeTree(){
        root = setTreeNodes(null, expression.replace(" ", "")); //using this to take care of white spaces
                
    }
    
    //this method populates the tree nodes
    private Node setTreeNodes(Node node, String currentExpression){
        
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
        
        //here I populate the left and right nodes recursively 
        if (currentExpression.length() > 0){
            if (!current.isEmpty()){
                Node nodeToAdd = new Node(current.replace("(", "").replace(")", "")); //taking care of the parentheses
                
                //if the current expression is greater than 0 meaning it still needs to broken into two
                //it will set the root of the subtree as the operator
                //it will then set the left and right children recursively
                nodeToAdd.isOperator = isOperator;
                node = nodeToAdd;
                node.left = setTreeNodes(node.left, leftSide);
                node.right = setTreeNodes(node.right, rightSide);
            }else{
                //here we are creating the left and right children
                if (leftSide.length() > 0){
                    node = new Node(rightSide.replace("(", "").replace(")", ""));                  
                }
                else if(rightSide.length() > 0){
                    node = new Node(rightSide.replace("(", "").replace(")", ""));
                }
                node.left = setTreeNodes(node.left, leftSide);
                node.right = setTreeNodes(node.right, rightSide);
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
        
        //traversing the string to determine the level. the original expression is level 0, each open parentheses
        //marks another level. This takes care of the elements within the parentheses to follow the order of operation.
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
        
        int rootIndex = -1;
        
        if(operators.size() > 0){
            int additionIndex = -1;
            int subtractionIndex = -1;
            int multiplicationIndex = -1;
            int divisionIndex = -1;
            int maxParenLvl = maxIndex(operators); 
            
            for (int i = 0; i <= maxParenLvl; i++){
                for (ExpOper op : operators){
                    
                    //here we are storing the latest index in the expression, depending on which level they are 
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
                //making sure we use the right index as the root of the tree and subtrees
                //if the index of the addition sign is greater and therefore later on the string than the subtraction
                //then we use the addition, otherwise we use the subtraction
                rootIndex = additionIndex > subtractionIndex ? additionIndex : subtractionIndex;
                
                if (rootIndex == -1){
                    rootIndex = multiplicationIndex > divisionIndex ? multiplicationIndex : divisionIndex;
                }
                
                if (rootIndex != -1){
                    break;
                }
            }
        }
        return rootIndex;
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
        //it returns the expression as a String

        return String.valueOf(setExpression(root));
       
    }
    
    //traversing through the tree in post order doing all the arithmetic
    private int setExpression(Node node){
        
        int result;
        int operand1;
        int operand2;
        
        //base case
        if (node == null){ 
            result = 0;
        }
        else{
            Node tempNode = node;
            
            if(node.isOperator){
                
                //if the node passed into the method is an operand it will check for and set its left and right children
                //into variables, left child is the operand 1 and right child is operand 2
                //this is done recursively storing the result
                operand1 = setExpression(node.left); 
                operand2 = setExpression(node.right);
                result = doMath(tempNode.value.charAt(0), operand1, operand2);
            }else{
                try{
                    
                    result = Integer.parseInt(tempNode.value);
                    
                }catch (NumberFormatException e){
                    
                    result = 0;
                }
            }
        }
        return result;                
    }
    
    //method doing the math and returning the result
    private int doMath(char op, int operand1, int operand2){
        
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
    
    //getting the max index of the array
    private int maxIndex(ArrayList<ExpOper> operators){
        int maxIndex = 0;
        
        for (ExpOper item : operators){
            if(item.parenLvl > maxIndex){
                maxIndex = item.parenLvl;
            }
        }
        return maxIndex;
    }
   
    
}
