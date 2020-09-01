package app;


public class Controller {

    public static void main(String[] args) {
       
        for(int i=1; i<=7; i++){
            while(i%2 == 1){
                System.out.print(i + "\t");
                i++;
                
                if(i<=3){
                    System.out.print(i-1 + "\t");
                }                       
            }
        }
    }
    
}
