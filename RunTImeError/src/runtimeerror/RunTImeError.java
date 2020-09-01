
package runtimeerror;


public class RunTImeError {


    public static void main(String[] args) {
        
        int[] numbers = new int[10];
        
        try{
            for(int i=0; i<=9; i++){
                numbers[i] = i;
            }
        }catch(ArithmeticException e){
            System.out.println("");
            System.out.println("Catching an ArithmeticException");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("");
            System.out.println("Catching an ArrayIndexOutOfBoundsException");
        }catch(Exception e){
            System.out.println("");
            System.out.println("Catching an Exception");
        }finally{
            System.out.println("In Fianlly block");
            System.out.println("");
        }
        
    }
    
}
