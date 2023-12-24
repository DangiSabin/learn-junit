package org.example;

public class BankAccount {
    private double balance;
    private double minimumBalance;
    private boolean isActive=true;
    private String holderName;
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public double getBalance() {
        return balance;
    }
    public double getMinimumBalance() {
        return minimumBalance;
    }
    public BankAccount(double balance, double minimumBalance){
        this.balance=balance;
        this.minimumBalance=minimumBalance;
    }
    public void withdraw(double amount){
        if(balance-amount>minimumBalance){
            balance-=amount;
           // return amount;
        }
        else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){
       // Thread.sleep(5);
        return balance+=amount;
    }
}
