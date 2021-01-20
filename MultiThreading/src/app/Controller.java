/*
Multi-threading 
A thread is a program tha is executed independently of other parts of the program.
- the JVM (Java Virtual Machine) executes each thread for a short amount of time
and then switches to another thread, giving the illusion of executing the threads in parallel to each other.
Actually, if a computer has multiple central processing units (CPU) then some of the threads can run in parallel, one on each processor.

Steps:
1. Write a call tha implements the Runnable interface. That interface has a single method called run();
    public interface Runnable {
        void run();
    }

2. Place the code for your task into the run method of your class:
    
    public class MyRunnable implements Runnable
    {
        public void run()
        {
            **TASK STATEMENTS.
            ....
        }
    }

3. Create an object of your runnable class:
    
    Runnable r = new MyRunnable();

4. Construct a Thread object from the runnable object:

    Thread t = new Thread(r);

5. Call the start method to start the thread:
    
    t.start();
 */
package app;

/**
 *
 * @author josrh
 */
public class Controller {

    public static void main(String[] args) {
        
        GreetingRunnable r1 = new GreetingRunnable("HELLO");
        GreetingRunnable r2 = new GreetingRunnable("GOODBYE");
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        
        t1.start();
        t2.start();
             
    }
    
}
