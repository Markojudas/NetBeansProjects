package app;

public class Controller {

    public static void main(String[] args) {
        
        String[] letters = {"a", "b", "c"};
    
        try{
            
            int[] numbers = new int[10];
            
            for (int i = 0; i<=9; i++){
                numbers[i] = 1;
            }
            
            letters[2] = "2";
            
        }catch(ArithmeticException e){
            System.out.println("");
            numbers[0] = 10;
            System.out.println("Catching an ArithmeticException");
            
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("");
            letters[2] = "d";
            System.out.println("Catching an ArrayIndexOutOfBoundsException");
            
        }catch(Exception e){
            System.out.println("");
            letters[4] = "e";
            numbers[2] = 3;
            System.out.println("Catching an Exception");        
        }finally{
            System.out.println("In Finally Block");
            System.out.println("");
        }

    }
    
}
