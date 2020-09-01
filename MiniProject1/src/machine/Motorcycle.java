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
public class Motorcycle extends Vehicle {
   
    //class variable
    private static final String CLASSIFICATION = "Motorcycle";
    private static final String CODE = "M";
    
    //instance variables
    protected String color;
    protected String engineType;
    protected double mileage;
    
    //constructor
    public Motorcycle(String color){
        super();
        
        //id comes from the superclass Vehicle
        id = CODE + "-" + id;
        
        this.color = color;
        this.engineType = "Gasoline";
        mileage = 0.0;
    }
    
    //not inherited from Vehicle class
    private void displayHeader(){
        System.out.println("");
        System.out.println("=========================================");
        System.out.println("Motorcycle Info");
        System.out.println("=========================================");
    }
    
    @Override
    public void displayInfo(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        
        displayHeader();
        System.out.println("Classification:\t\t" + CLASSIFICATION);
        
        System.out.println("ID:\t\t\t" + id);
        System.out.println("Factory:\t\t" + factory);
        System.out.println("Build Time:\t\t" + dateFormat.format(super.getBuildTime()));
    }
    
    public void go(){
        System.out.println("");
        System.out.println("Motorcycle's go() executed");       
    }
    
    public void stop(){
        System.out.println("");
        System.out.println("Motorcycle's stop() executed");          
    }
    
    public void wheelie(){        
        System.out.println("Motorcycle's wheelie() executed");
    }
    
}
