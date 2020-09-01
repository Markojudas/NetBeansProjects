/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package living_things;


public class Dog extends Organism{
    
    private String breed;
    
    public Dog(){
        this("Unknown", "Unknown");
            }
    
    public Dog(String name, String breed){
        super(name);
        this.breed = breed;
    }
    
    @Override
    public void talk(){
        System.out.println("BARK BARK BARK");
        System.out.println("My name is " + getName()+ " and I am a(n) " + breed);
    }
}
