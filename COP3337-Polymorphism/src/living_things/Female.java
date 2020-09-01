/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package living_things;

public class Female extends Human {
    
    public Female(){
        this("Damarys", 41, "Female");
    }
    
    public Female(String name, int age, String gender){
        super(name, age, gender);
    }
    
    @Override
    public void talk(){
        System.out.println("My name is " + getName() + " and I'm " + getAge() + " years old and I identify as " + getGender());
        giveBirth();
    }
    
    //new method
    private void giveBirth(){
        System.out.println("I am able to give birth to kids");
    }
    
}
