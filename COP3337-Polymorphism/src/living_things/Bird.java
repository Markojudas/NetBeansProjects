/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package living_things;

public class Bird extends Organism {
    
    private boolean itFlies; 
    
    public Bird(){
        this("unknown", false);
    }
    
    public Bird(String name, boolean itFlies){
        super(name);
        this.itFlies = itFlies;
    }
    
    public boolean getItFlies(){
        return itFlies;
    }
    
    @Override
    public void talk(){
        System.out.println("TWEET TWEET TWEET");
        System.out.println("My name is " + getName());
        System.out.println("Can I fly?: " + getItFlies());
    }
    
}
