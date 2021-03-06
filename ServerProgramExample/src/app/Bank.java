/*
A bank consisting of multiple bank accounts (10)
*/
package app;

public class Bank {
    
    private BankAccount[] accounts;
    
    public Bank(int size){
        accounts = new BankAccount[size];
        for (int i = 0; i < accounts.length; i++)
            accounts[i] = new BankAccount();
    }
    
    public void deposit(int accountNumber, double amount){
        BankAccount account = accounts[accountNumber];
        account.deposit(amount);
    }
    
    public void withdraw(int accountNumber, double amount) throws InterruptedException{
        BankAccount account = accounts[accountNumber];
        account.withdraw(amount);
    }
    
    public double getBalance(int accountNumber){
        BankAccount account = accounts[accountNumber];
        return account.getBalance();
    }
    
    
    
}
