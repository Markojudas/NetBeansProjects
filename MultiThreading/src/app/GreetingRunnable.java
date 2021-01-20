/*
My Runnable class
 */
package app;
import java.util.Date;

public class GreetingRunnable implements Runnable {
    
    private static final int REPETITIONS = 10;
    private static final int DELAY = 1000;
    
    private String greeting;
    
    public GreetingRunnable (String aGreeting){
        greeting = aGreeting;
    }
    
    @Override
    public void run(){
        //To wait a second we use the staic sleep method of the Thread Class
        //The call puts the current thread to sleep for a given number of milliseconds (this case 1000 = 1 second)
        //putting a Thread to sleep is risky - it might sleep for so long that it is no longer useful and should be terminated
        //to terminate a Thread, we Interrupt it. When a sleeping thread is interruped, an InterruptedException is thrown
        //this exception needs to be handled/caught. 
        try{
            for (int i = 1; i <= REPETITIONS; i++){
                Date now = new Date();
                System.out.println(now + " " + greeting);
                Thread.sleep(DELAY);
            }
        }catch(InterruptedException exception){
            
        }
        
    }    
    
}
