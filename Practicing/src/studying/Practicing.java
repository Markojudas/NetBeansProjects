package studying;

import java.util.Scanner;

public class Practicing {

    public static void main(String[] args) {
        
        double x;
        double y;
        
        Scanner in = new Scanner(System.in);
        System.out.println("X: ");
        x = in.nextInt();
       
        if(x < 0){
            y = x;
        }
        else{
            y = 0;
        }
        
        System.out.println("Y: " + y);         
                
    }
    
}
