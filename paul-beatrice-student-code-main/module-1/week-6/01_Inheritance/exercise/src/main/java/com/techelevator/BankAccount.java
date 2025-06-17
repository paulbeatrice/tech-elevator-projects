package com.techelevator;

public class BankAccount {
    //Attributes
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    //Constructor 1: Initialize account with a balance of $0
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    //Constructor 2: Initialize account with a given balance
    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    //Getter for accountHolderName
    public String getAccountHolderName() {
        return accountHolderName;
    }
    //Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }
    //Getter for balance
    public int getBalance() {
        return balance;
    }
    //Method to deposit money
    public int deposit(int amountToDeposit) {
        if (amountToDeposit > 0) {
            balance += amountToDeposit;
        }
        return balance;
    }
    //Method to withdraw an amount
    public int withdraw(int amountToWithdraw) {
        if (amountToWithdraw > 0) {
            balance -= amountToWithdraw;
        }
        return balance;
    }
}
