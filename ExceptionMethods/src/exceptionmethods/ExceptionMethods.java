
package exceptionmethods;

import java.util.Arrays;

public class ExceptionMethods {

    public static void main(String[] args) {
        String[]  letters = {"a", "b", "c"};
        
        letters[2] = "2";
        
        System.out.println(Arrays.toString(letters));
        
        try{
          
        transaction(50);
        
      }catch(TransactionException e){
            System.out.println("");
            System.out.println("---------------------------------------");
            System.out.println("Inner Catch TransactionException");
            System.out.println("---------------------------------------");
            System.out.println("Error Code: " + e.getCodeError());
            System.out.println(e.getMessage());
            
        }//end try/catch 
        
    }
    
    public static void transaction(int code) throws TransactionException{
        
        int productCode = 100;
        
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("Executing transaction method");
        System.out.println("---------------------------------------");
        
         if(code < productCode){
         throw new TransactionException("Code is to small", "ErrorCode: 1");
        }//end if
         
        System.out.println("Transaction was ok");
    }
    
}
