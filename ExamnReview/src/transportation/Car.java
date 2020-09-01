/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportation;
import interfaces.Reporter;

/**
 *
 * @author josrh
 */
public class Car extends Vehicle implements Reporter {
    
    @Override
    public void go(){
        System.out.println("Running Car's go()");
    }
    
    @Override
    public void stop(){
        System.out.println("Running Car's stop()");        
    }
    
    @Override
    public void report(){
        System.out.println("Running Car's report()");
    }
}
