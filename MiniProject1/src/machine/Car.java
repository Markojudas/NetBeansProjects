/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine;
import java.text.SimpleDateFormat;

/**
 *
 * @author josrh
 */
//Car class is a subclass of the Vehicle class (superclass)
public class Car extends Vehicle{
    
    //class variables
    private static final String CLASSIFICATION = "Car";
    private static final String CODE = "C";
    
    //instance variables
    protected String color;
    protected String engineType;
    protected double mileage;
    private boolean seeHeader;
    
    //constructos
    public Car(){
        this("Black", "Gasoline");        
    }
    
    public Car(String color, String engineType){
        super();
        
        id = CODE + "-" + id;
        this.color = color;
        this.engineType = engineType;
        mileage = 0.0;
        seeHeader = true;
    }
    
    //overriden & overloaded methods
    //displayHeader is private so this not inherited from Vehicles 
    private void displayHeader(){
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("Car Info");
        System.out.println("=====================================");
    }
    
    //overriden displayInfo
    @Override
    public void displayInfo(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        
        if(seeHeader){
            displayHeader();
            System.out.println("Classification:\t\t" + CLASSIFICATION);
            
            //going into the superclass and calling the setSeeHeader method
            //change seeHeader from true to false
            super.setSeeHeader(false);
        }
        
        super.displayInfo();
        System.out.println("Color: \t\t\t" + color);
        System.out.println("Engine Type: \t\t" + engineType);
        
        //using printf to format the output to minus 10 and i decimal point??
        System.out.printf("Mileage: \t\t%-10.1f\n", mileage);
        
        //if statement to set SeeHeader from the Super class back to true if false
        if(!(super.getSeeHeader())){
            super.setSeeHeader(true);
        }       
    }
    
    //overriden go()
    public void go(){
        System.out.println("");
        System.out.println("Car's go() executed");        
    }
    
    //overloaded go()
    public void go(double distance){
        mileage += distance;
        
        System.out.println("");
        System.out.println("Car's go(double) excuted");
        System.out.printf("The car has " + mileage + " mile on it now."); //why printf heere?
    }
    
    //overriden stop()
    public void stop(){
        System.out.println("");
        System.out.println("Car's stop() executed");        
    }
    
}
