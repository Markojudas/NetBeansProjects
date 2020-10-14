
package payments.credit;

import entities.Item;
import entities.Logger;
import entities.Person;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import reports.CreditCardReport;
import reports.FinancialReport;
import reports.PersonReport;
import reports.Reporter;
import transactions.SecureTransaction;


public class MasterCard  extends CreditCard implements Reporter, SecureTransaction {
    
    // DO NOT CHANGE THE ACCESS MODIFIERS NAYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
   
    // DO NOT CHANGE THE ACCESS MODIFIERS NAYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO

   
    //----------------------------------------
    // class variables
    //----------------------------------------  
    private static ArrayList<String> issuedNumbers = new ArrayList<>(); 
    
    
    // DO NOT CHANGE THE ACCESS MODIFIERS NAYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
    
    // THIS CLASS IS OK
   
    //----------------------------------------
    // instance variables
    //----------------------------------------  
    private double interestRate;
    protected String cardNumber; 
    protected double totalFees;
    
    // bad design here
    protected ArrayList<Item> purchases;
    protected ArrayList<Date> transactionTime;
    
    
    //----------------------------------------
    // constructor 
    //----------------------------------------  
    

    public MasterCard(Person cardHolder, double creditLimit) {
        
        super(cardHolder, creditLimit, 0);
        
        type = "MasterCard";
        totalFees = 0;
        
System.out.println("");
System.out.println("//////////////////////////////////////////////");    
System.out.println("Section 2.1");       
System.out.println("//////////////////////////////////////////////");  

        // write the code that give a card a did interest rate depending on the
        // credit score of the cardholder
        // The rule:
        // score >= 740 implies a interest rate of 10.99
        // 740 > score >= 670 implies a interest rate of 12.50
        // score < 670 implies a interest rate of 14.99
        // WRITE YOUR CODE HERE
        
        
        
        if(cardHolder.getCreditScore() >= 740){
            interestRate = 10.99;
        }else if (cardHolder.getCreditScore() >= 670){
            interestRate = 12.50;
        }else{
            interestRate = 14.99;
        }
        
        
        
       generateCardNumber();
        
        
        purchases = new ArrayList<Item>();
        transactionTime = new ArrayList<Date>();
    
    }
    
    //----------------------------------------
    // instance method 
    //----------------------------------------  
    
    
    private void generateCardNumber(){
        
        Random renGen = new Random();
        boolean hasBeenIssued = false;
        
        cardNumber = "";
        
System.out.println("");
System.out.println("//////////////////////////////////////////////");    
System.out.println("Section 3.1");       
System.out.println("//////////////////////////////////////////////");  
      
        
        
        // you need to write code that creates 
        // a random create number that has not been
        // issued in the past....
        
        // the format of the card
        // 8234 7456 6307 7049 
        // in the end you get a string that looks like this
        
        // hint:
        // the cardNumber variable is a string
        // generate a random number in the range 0 - 9
        // then append this to the cardNumber variable....
        // exaample
        // cardNumber = cardNumber + nyRandomNumber; 
        // 
        
        // NOT THIS IS THE WRONG FORMAT
        /// 8234745663077049 -> no spaces... I will take points off

        // I WILL CHECK YOU IF ARE CHECKING THE NEW RANDOM
        // CREATE AGAINST ALL PASS ISSUED CARD NUMBERS
        // IF YOU DO NOT DO THIS OYU  WILL LOSE POINTS
        
        // if you understand this class and the credit card this is 
        // easy to do.....
        
      
         // generate card number
        // Hint: use a do - while  loop here
        // YOUR CODE HERE
        do{
            for(int i = 1; i < 20; i++){
                if((i !=5) && (i !=10) && (i !=15)){
                    int randCardNum = renGen.nextInt(10);
                    cardNumber = cardNumber + randCardNum;
                }
                else{
                    cardNumber = cardNumber + " ";
                }               
            }
            if(!(issuedNumbers.contains(cardNumber))){
                    issuedNumbers.add(cardNumber);
                    hasBeenIssued = true;
            }       
        } while (!hasBeenIssued);
        
        
        
    }
    
    protected  void fees(){
        
        double fee =0;
       
        if(purchases.size() > 0 && purchases.size()%3 == 0){
            fee = balance * interestRate/500;
            totalFees +=fee;
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            
            String sender = "MC-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + String.format("  $%-5.2f fee charged", fee);
            Logger.output(sender, message);
            
        }//end if
       
        
    }
    
    public void makePurchase(Item item){
        
        if(item.getPrice() <= (creditLimit - balance)){
            
            Date date = new Date();
            
            balance += item.getPrice();
            purchases.add(item);
            transactionTime.add(date);
            
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + "  Charged " + item.getName() + " for $" + item.getPrice();
            
            Logger.output(sender, message);
            
            fees();
            
            CreditCard.setCreditTransactionCount(CreditCard.getCreditTransactionCount()+ 1);
            
        }else{
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + " Charge declined due to credit limits";
            Logger.output(sender, message);
        }//end if-else
    }
    
    
        public void makePurchase(Item item, String pin){
        
        if(item.getPrice() <= (creditLimit - balance)){
            
            Date date = new Date();
            
            balance += item.getPrice();
            purchases.add(item);
            transactionTime.add(date);
            
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC:SECURE-" + cardHolder.getLastName()+ "-" + pin;;
            String message = "<" + dateStr + ">" + "  Charged " + item.getName() + " for $" + item.getPrice();
            
            Logger.output(sender, message);
            
            fees();
            
        }else{
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC:SECURE-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + " Charge declined due to credit limits";
            Logger.output(sender, message);
        }//end if-else
    }
    

    public void infoReport(){
        
          Map<String, Object> map = new LinkedHashMap<>();
        
       
        
        ArrayList<String> header = new ArrayList<>();
        
        header.add("");
        header.add("=======================================");
        header.add(type + " Info Report");
        header.add("=======================================");

        
        map.put("Card Holder", cardHolder.getFirstName() + " " + cardHolder.getLastName());
        map.put("Number", "\t"+ cardNumber);
        map.put("Interest Rate", String.format("%-4.2f%%",interestRate));
        map.put("Credit Limit", String.format("%-10.2f", creditLimit));
        map.put("Balance", String.format("%-10.2f",  balance));
        map.put("Remaining Credit", String.format("%-10.2f", (creditLimit - balance)) );
        map.put("Fees", String.format("\t%-10.2f", totalFees ));
        map.put("Transaction Count", transactionTime.size());
        
     
       CreditCardReport creditCardReport = new CreditCardReport(header, map);
       creditCardReport.display();
        
        
    }

    public double getInterestRate() {
        return interestRate;
    }
    
    
    
    //==============================================
    // reporter interface methods
    //==============================================
    public void runReports(){
        infoReport();
    }
    
    // ------------------------------------------------------
    // SecureTransaction Interface
    // ------------------------------------------------------


    public void secureTransaction(Item item) {
         String pin = generateTransactionSecret();
         makePurchase(item, pin);
    }
    
    
        public String  generateTransactionSecret(){
            
System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 10");       
System.out.println("//////////////////////////////////////////////");  
        
                
        // if you are a creditcard type
        // from left to right make the pin from following digits of the card number
        // 1, 5, 9, 13
        // Example     
        // 2341 4833 9332 9933   <- card number
        // 2    4    9    9      <- selected number
        // pin is 2499           <- generated pin

        String pin = "";
        String getCardNum = cardNumber;
        
        for(int i=0; i < getCardNum.length(); i+=5){
            char cardPin = getCardNum.charAt(i);
                               
            pin = pin + cardPin;
        }
    
        //debugging code
        //System.out.println("Pin:\t" + pin);
       
        return pin;
     }
    
}//end class
