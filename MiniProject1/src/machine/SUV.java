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
public class SUV extends Car {
    
    //class variables
    private static final String CLASSIFICATION = "SUV";
    private static final String CODE = "S";
    
    //instance variable
    protected boolean hasAllWheelDrive;
    
    //constructors
    //default contructor
    public SUV(){
        super();
        
        id = CODE + "-" + id;
        hasAllWheelDrive = false;
    }
    
    //constructor with parameters string string & boolean
    public SUV(String color, String engineType, boolean hasAllWheelDrive){
        super(color, engineType);
        this.hasAllWheelDrive = hasAllWheelDrive;        
    }
    
    //instance methods
    
    private void displayHeader(){
        System.out.println("");
        System.out.println("========================================");
        System.out.println("SUV's Info");
        System.out.println("========================================");
    }
    
    //overriden methods
    @Override
    public void displayInfo(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        
        displayHeader();
        
        super.setSeeHeader(false);
        
        super.displayInfo();
        
        System.out.println("All-Wheel-Drive:\t" + hasAllWheelDrive);
     
        if(!(super.getSeeHeader())){
            super.setSeeHeader(true);
        }
    }
    
    public void engageAllWheelDrive(){
        if(hasAllWheelDrive){
            System.out.println("Engaging All-Whell-Drive in the SUV");
        }
        else{
            System.out.println("Sorry All-Wheel-Drive cannot be engaged in the SUV");
        }        
    }
}
