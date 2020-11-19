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
public class TestHashing extends PhoneNumber {

    public static void main(String[] args) {
        
        Customer customer1 = new Customer("Jose Hernandez", "22 Acacia Avenue", "3057166694");
        Customer customer2 = new Customer("Aiorius Stormlord", "53rd St 3rd Ave", "7183457689");
        Customer customer3 = new Customer("Largetha Lothbrok", "Somewhere in Valhalla", "7864786532");
        Customer customer4 = new Customer("Cassandra Lightdimmer", "Around The Block", "9548769899");
        Customer customer5 = new Customer("Michael Kiske", "Future World Ave", "4675434498");
        CustomerHashing ht = new CustomerHashing();
        
        ht.put("6694", customer1);
        ht.put("7689", customer2);
        ht.put("6532", customer3);
        ht.put("9899", customer4);
        //ht.put("", customer5);
               
       ht.printTable();
        
        
    }
    
}
