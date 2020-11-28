/*
Programmer: Jose R Hernandez
Course: Data Structures - COP3530RVC 1208
Semester: Fall 2020
Professor: Joslyn Smith

Assignment 3

This program uses the concept of Hashing to store customer's record, which
comprises of their telophone number, name, and postal address.
It uses the last four digits of the telephone number as the hash key, and uses
the Chaning method to handle any possible collision.

The program will be able to:
    1. Buld a hash table by insterting a phone number and the correspondingh information
    2. Search a phone number and fetch the information
    3. Delete a phone number and related information
*/
package app;
//this is the main/test class
public class TestHashing {

    public static void main(String[] args) {
        
        
        //Creating phone numbers & passing the numbers as the phone parameter to create customers
        String phone1 = "(305)716-6694";
        Customer customer1 = new Customer("Jose Hernandez", "22 Acacia Avenue", phone1);
        
        String phone2 = "(718)345-7689";
        Customer customer2 = new Customer("Aiorius Stormlord", "53rd St 3rd Ave", phone2);

        String phone3 = "(786)478-6532";        
        Customer customer3 = new Customer("Largetha Lothbrok", "Somewhere in Valhalla Ave", phone3);
        
        String phone4 = "(954)876-9899";
        Customer customer4 = new Customer("Cassandra Lightdimmer", "Somewhere in Time Place", phone4);
        
        String phone6 = "(954)138-5501";
        Customer customer6 = new Customer("Saint Seiya", "Somewhere far Beyond Street", phone6);

        //creating the hashtable
        CustomerHashing ht = new CustomerHashing();
        
        //adding the customers
        ht.put(phone1, customer1);
        ht.put(phone2, customer2);
        ht.put(phone3, customer3);
        ht.put(phone4, customer4);
        ht.put(phone6, customer6);
             
        //printing the hashtable with the original customers
        System.out.println("==================================================");
        System.out.println("BUILDING AND PRINTING THE HASHTABLE");
        System.out.println("==================================================");
        ht.printTable();
        
        //creating and adding another customer forcing a collision test the chaining method of handling collision
        //this new customer would be "chained" with a previous customer under the same index
        System.out.println("==================================================");
        System.out.println("CAUSING A COLLISION & REPRITING THE TABLE");
        System.out.println("==================================================");
        
        String phone5 = "(467)543-4498";        
        Customer customer5 = new Customer("Michael Kiske", "Future World Ave", phone5);       
        
        //adding this customer to the table
        ht.put(phone5, customer5);
        
        //printing the table to show the collision handling
        ht.printTable();      
        
        //searching for a customer
        System.out.println("===================================================");
        System.out.println("SEARCH FOR A CUSTOMER");
        System.out.println("===================================================");
        System.out.println(ht.search(phone3));
        System.out.println(ht.search(phone5));
        System.out.println("===================================================");
        
        //deleting a customer from the table & printing the table again
        System.out.println("DELETING A CUSTOMER & REPRINTING THE TABLE");
        System.out.println("===================================================");
        ht.delete(phone1);
        ht.printTable();
        
        
        
    }   
    
}
