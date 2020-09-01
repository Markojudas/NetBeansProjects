/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package living_things;


public class Organism {
    
    private String name;
    
    public Organism(){
        this("No name given");
    }
    
    public Organism(String name){
        this.name = name;
    }
    
    public void setName(String name){
        this.name= name;
    }
    
    public String getName(){
        return name;
    }
    
    public void talk(){
        System.out.println("I am alive but I don't know what I am!");
    }
    
    public void reproduce(){
        System.out.println("the meaning of life is to reproduce");
    }
}
