/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportation;


public class SUV extends Car {
    
    @Override
    public void go(){
        System.out.println("Running SUV's go()");
    }

    public void allWheelDrive(){
        System.out.println("Active all wheel drive!");
    }
}
