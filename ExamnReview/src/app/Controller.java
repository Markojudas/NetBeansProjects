/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;
import transportation.Vehicle;
import transportation.Bike;
import transportation.Car;
import transportation.SUV;
import interfaces.Reporter;
import transportation.RollerSkate;

public class Controller {

    public static void main(String[] args) {
       
       //Vehicle vehicle = new Vehicle();
       //cannot create an object from an abstract class
       Bike bike = new Bike();
       Car car = new Car();
       SUV suv = new SUV();
       Vehicle suv2 = new SUV();
       RollerSkate skate = new RollerSkate();
       Vehicle skate1 = new RollerSkate();

      suv.go();
      suv.stop();
      ((Car)suv).go();
     
      
      
      suv2.go();
      suv2.stop();
     ((Vehicle)suv2).go();
     
     suv2.report();
     System.out.println("");
     System.out.println("playing with suv2");
     ((Vehicle)suv2).report();
     System.out.println("");
     
     System.out.println("playing with skate");
     skate.report();
     skate.go();
     System.out.println("");
     
     System.out.println("playing with skate1");
     skate1.report();
     skate1.go();
     System.out.println("");
   
     
      processStop(car);
      processStop(suv);
      //processStop(bike); <-- Bike does not extend Vehicle and it cannot be converter to Vehicle
      
      report(car);
      report((Car)suv2);
      //report(suv2); <---- this does not work because suv2 is of type vehicle
                        //line 57 we are downcasting the suv2 into a a Car becuase SUV extends Car
                        //and car implements Reporter
      
      report(suv); //<---- this works because suv is of type SUV which extends Car
      report(bike);
      
    
    }
    
    public static void processStop(Vehicle v){
        v.stop();
    }
    
    public static void report(Reporter reporter){
        reporter.report();
    }
    
}
