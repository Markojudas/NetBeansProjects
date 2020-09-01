/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import living_things.Human;
import living_things.Bird;
import living_things.Dog;
import living_things.Organism;
import living_things.Male;
import living_things.Female;

import java.util.*;

public class Controller {

        
    public static void main(String[] args) {
        
        String thing;
       
        Scanner in = new Scanner(System.in);
              
        System.out.println("What are you?");
        System.out.println("Human, Dog, Bird, unknown");
        thing = in.nextLine();
        
        String name = getName();
        
        if(thing.equalsIgnoreCase("HUMAN")){
            int age;
            String gender;
                                 
            System.out.println("Gender? (Male or Female)");
            gender = in.nextLine();
            
                        
            System.out.println("Age?");
            age = in.nextInt();
                     
            Human human = new Human();
            onStage(human);
            
            if(gender.equalsIgnoreCase("MALE")){
                Male male = new Male(name, age, gender);
                onStage(male);
            }
            else if(gender.equalsIgnoreCase("FEMALE")){
                Female female = new Female(name, age, gender);
                onStage(female);
                
                Human.reproduce(female);
            }
        }
        else if (thing.equalsIgnoreCase("DOG")){
            String breed;
            System.out.println("What breed of dog are you?");
            breed = in.nextLine();
                       
            Dog dog = new Dog(name, breed);
            onStage(dog);
            Human.reproduce(dog);
            
        }
        else if (thing.equalsIgnoreCase("BIRD")){
            boolean canFly = false;

            Random rnd = new Random();
            
            int flight = rnd.nextInt(2);
            
            if(flight != 0){
                canFly = true;
            }
            String itFlies;
            itFlies = (canFly ? "yes" : "no");
            
            Bird bird = new Bird(name, canFly);
            onStage(bird);
            
        }
        else{
            Organism organism = new Organism("Single Cell");
            onStage(organism);
        }
    }
    
    public static String getName(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("What is your name?");
        String name = in.nextLine();
        
        return name;
    }
    
    public static void onStage(Organism o){
        o.talk();
    }
    
}
