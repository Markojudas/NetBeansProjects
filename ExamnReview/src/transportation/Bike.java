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
public class Bike implements Reporter {
    
    public void go(){
        System.out.println("Running Bike's go()");
    }
    
    @Override
    public void report(){
        System.out.println("Running Bike's report()");
    }
}
