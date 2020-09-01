/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package living_things;

/**
 *
 * @author josrh
 */
public class Male extends Human {
    
    public Male(){
        this("John", 45, "Male");
    }
    
    public Male(String name, int age, String gender){
        super(name, age, gender);
    }
    
    @Override
    public void talk(){
        System.out.println("My name is " + getName() + " and I am " + getAge() + " years old. I identify as " + getGender());
    }
   
}
