//this class is used to help determine which operator to use to create the root
//Since the root would be the last operator with the least precedence.
//we are counting on the position or index of the operator on the string

package app;

public class ExpOper {
    
    public int index;
    public String Operator;
    public int parenLvl;

    public ExpOper(int Index, String Operator, int parenLvl) {
        this.index = Index;
        this.Operator = Operator;
        this.parenLvl = parenLvl;
    }
    
}
