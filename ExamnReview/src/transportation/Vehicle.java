/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportation;


public abstract class Vehicle {
    
    public abstract void go();
    
    public void go(int distance){
        System.out.println("Running Vehicle's go(int)");
    }
    
    public void stop(){
        System.out.println("Running Vehicle's stop()");
    }
    
    public void report(){
        System.out.println("This is the Vehicle Report without implementing");
    }
    
}
