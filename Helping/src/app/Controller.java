/*

 */
package app;
import java.util.Arrays;

/**
 *
 * @author josrh
 */
public class Controller {


    public static void main(String[] args) {
        
        int [] sequence = {1, 1, 2, -3, -29, -108, -243, -179, 1282, 7417,
            22871, 40572, -12023, -405879, -1754238, -4521563, -5531429,
            13774852, 110895797, 388591221};
        
        int [] currentSequence = new int[20];
        
        int gx = 0;
        int gy = 0;
        int gz = 0;
        
        for(int x = -10; x <= 10; x++){
            for(int y = -10; y <= 10; y++){
                for(int z = -10; z <= 10; z++){
                    for (int n = 0; n < 20; n++){
                        int currentValue = fib(n+1,x,y,z);
                        currentSequence[n] = currentValue;
                    }
                    if(Arrays.equals(currentSequence, sequence)){
                        System.out.println(Arrays.toString(currentSequence));
                    }
                }
            }
        }
        
        
    }
    
    public static int fib(int n, int x, int y, int z){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        return x*fib(n-1,x,y,z) + y*fib(n-2,x,y,z) + z*fib(n-3,x,y,z);
    }
    
}
