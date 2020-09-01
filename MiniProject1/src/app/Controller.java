/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import machine.Car;
import machine.Motorcycle;
import machine.SUV;
import machine.Vehicle;

/**
 *
 * @author josrh
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        
        vehicle.displayInfo();
        
        Car car1 = new Car("Blue", "Diesel");
        Car car2 = new Car();
        
        car1.displayInfo();
        car2.displayInfo();
        
        ((Vehicle)car2).displayInfo();
        
        car2.go(172.3);
        car2.displayInfo();
        
        SUV suv = new SUV();
        
        suv.displayInfo();
        ((Car)suv).displayInfo();
        ((Vehicle)suv).displayInfo();
        
        //cannot dude (Motorcycle)suv. because they are not related
        
        System.out.println("\n\nSUV Calling go Methods");
        System.out.println("===============================");
        suv.go();
        suv.go(2503.2);
        System.out.println("");
        
        Motorcycle motorcycle = new Motorcycle("Black");
        motorcycle.go();
        motorcycle.wheelie();
        motorcycle.displayInfo();
        
        Vehicle car3 = new Car("Red", "Electric");
        
        car3.go();
        
        //can't do car3.go(30.5) because though car3 of tyoe Vehicle
        //go(double) is a method of the Car Class
        
        ((Car)car3).go(30.3);
        
        car3.displayInfo();   
        
    }
        
}
