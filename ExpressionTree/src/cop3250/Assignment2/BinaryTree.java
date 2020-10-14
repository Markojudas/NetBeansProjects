package cop3250.Assignment2;

public class BinaryTree {
    
    public BinaryTreeNode root;
    public String expression;
    
    public BinaryTree(String expression){
        this.expression = expression;
        populateTreeNode();        
    }
    
    public void populateTreeNode(){
        
        buildChildren(root, expression.replace("(", "").replace(")", "").replace(" ", ""));
        
    }
    
    private void buildChildren(BinaryTreeNode treeRoot, String currentExpression){
        
        if (currentExpression.length() == 0){
            return;
        }
        
        var index = calculateIndex(currentExpression);
        var currentOp = currentExpression.substring(index, index + 1);
        var leftSide = currentExpression.substring(0, index);
        var rightSide = currentExpression.substring(index + 1);
        
        if (treeRoot == null){
            treeRoot = new BinaryTreeNode(currentOp);
            root = treeRoot;
            buildLeftSide(treeRoot, leftSide);
            buildRightSide(treeRoot, rightSide);
        }
        
        if (index > 0 && leftSide.length() == 1){
            treeRoot.leftChild = new BinaryTreeNode(leftSide);
            if (rightSide.length() > 1){
                var foundIndex = calculateIndex(rightSide);
                currentOp = rightSide.substring(foundIndex, foundIndex + 1);
                treeRoot.rightChild = new BinaryTreeNode(currentOp);
                buildChildren(treeRoot.rightChild, rightSide);
            }
        }
        if (index > 0 && rightSide.length() == 1){
            treeRoot.leftChild = new BinaryTreeNode(rightSide);
            if(leftSide.length() > 1){
                var foundIndex = calculateIndex(leftSide);
                currentOp = leftSide.substring(foundIndex, foundIndex +1);
                treeRoot.leftChild = new BinaryTreeNode(currentOp);
                buildChildren(treeRoot.leftChild, leftSide);
            }
        }
    }
    
    private void buildLeftSide(BinaryTreeNode treeRoot, String leftSide){
        
        if (leftSide.length() == 1){
            treeRoot.insertLeft(leftSide);
        }
        else if(leftSide.length() == 0){
            return;
        }
        else{
            buildChildren(treeRoot, leftSide);
        }
    }
    
    private void buildRightSide(BinaryTreeNode treeRoot, String rightSide){
        
        if (rightSide.length() == 1){
            treeRoot.insertRight(rightSide);
        }
        else if (rightSide.length() == 0){
            return;
        }
        else{
            buildChildren(treeRoot, rightSide);
        }
    }
    
    public int calculateIndex(String expression){
        String additionSubtraction = "+-";
        String multiplicationDivison = "*/";
        String characters = "";
        
        for (var item : expression.toCharArray()){
            if (additionSubtraction.indexOf(item) > -1 || multiplicationDivison.indexOf(item) > -1){
                characters += item;
            }            
        }
        
        int indexToUse;
        if (characters.contains("+") || characters.contains("-")){
            var additionIndex = expression.lastIndexOf("+");
            var subtractionIndex = expression.lastIndexOf("-");
            indexToUse = additionIndex > subtractionIndex ? additionIndex : subtractionIndex;
        }
        else{
            var multiplcationIndex = expression.lastIndexOf("*");
            var divisionIndex = expression.lastIndexOf("/");
            indexToUse = multiplcationIndex > divisionIndex ? multiplcationIndex : divisionIndex;
        }
        
        if(indexToUse == -1){
            indexToUse = 0;
        }
        return indexToUse;
    }
    
        public void traverseInOrder(){
        if (root != null){
            root.traverseInOrder();
        }
    }

}
