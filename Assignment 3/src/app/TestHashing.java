/*
Programmer: Jose R Hernandez
Course: Data Structures - COP3530RVC 1208
Semester: Fall 2020
Professor: Joslyn Smith

This program uses the concept of Hashing to store customer's record, which
comprises of their telophone numnber, name, and postal address.
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
        
        String phone1 = "(305)716-6694";
        Customer customer1 = new Customer("Jose Hernandez", "22 Acacia Avenue", phone1);
        
        String phone2 = "(718)345-7689";
        Customer customer2 = new Customer("Aiorius Stormlord", "53rd St 3rd Ave", phone2);

        String phone3 = "(786)478-6532";        
        Customer customer3 = new Customer("Largetha Lothbrok", "Somewhere in Valhalla", phone3);
        
        String phone4 = "(954)876-9899";
        Customer customer4 = new Customer("Cassandra Lightdimmer", "Around The Block", phone4);
        

        
        CustomerHashing ht = new CustomerHashing();
        
        //adding the customers
        ht.put(phone1, customer1);
        ht.put(phone2, customer2);
        ht.put(phone3, customer3);
        ht.put(phone4, customer4);
             
        //printing the hashtable with the original customers
        
        System.out.println("==================================================");
        System.out.println("BUILDING AND PRINTING THE HASHTABLE");
        System.out.println("==================================================");
        ht.printTable();
        System.out.println("==================================================");
        System.out.println("CAUSING A COLLISION & REPRETING THE TABLE");
        System.out.println("==================================================");
        
        String phone5 = "(467)543-4498";        
        Customer customer5 = new Customer("Michael Kiske", "Future World Ave", phone5);       
        
        ht.put(phone5, customer5);
        
        ht.printTable();      
        
        System.out.println("===================================================");
        System.out.println("SEARCH FOR A CUSTOMER");
        System.out.println("===================================================");
        System.out.println("Searching for Largetha:\n\n" + ht.get(phone3));
        System.out.println("===================================================");
        
        System.out.println("DELETING CASSANDRA & REPRINTING THE TABLE");
        System.out.println("===================================================");
        ht.delete(phone5);
        ht.printTable();
        
        
        
    }   
    
}
