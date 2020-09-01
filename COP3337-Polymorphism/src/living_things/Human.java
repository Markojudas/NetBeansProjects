/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package living_things;
import java.util.Random;

public class Human extends Organism {
    
    
    private int id;
    private int age;
    private String gender;
    
    public Human(){
        this("A human has no name", 0, "unknown gender");
    
    }
    
    public Human(String name, int age, String gender){
        
        super(name);
        this.age = age;
        this.gender = gender;

                   
    }
 
    public int getId(){
        return id;
    }
      
    public int getAge(){
        return age;
    }
    
    public String getGender(){
        return gender;
    }
    
    @Override
    public void talk(){
        System.out.println("I am a Human!");
    }
    
    public static void reproduce(Organism d){
        d.reproduce();
    }
    
}
