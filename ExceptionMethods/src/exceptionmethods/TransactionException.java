
package exceptionmethods;


public class TransactionException extends Exception {
    
     private String codeError;
    
    public TransactionException(String message, String codeError){
        
        super(message);
        this.codeError = codeError;
    }
    
    public String getCodeError(){
        return codeError;
    }
    
}
