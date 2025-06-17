package com.techelevator;

public class SavingsAccount extends BankAccount {
    //Constructor that calls the parent constructor
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    //Override the withdraw method with additional rules
    @Override
    public int withdraw(int amountToWithdraw) {
        int currentBalance = getBalance();
        int newBalance = currentBalance - amountToWithdraw;

        //Check if the remaining balance would be less than $150 after withdraw
        if(newBalance < 150) {
            //Apply $2 Service Charge
            newBalance -=2;
        }

        // Prevent withdraw if it would result in negative balance
        if(newBalance < 0) {
            return currentBalance;
        }

        // Perform withdraw with or without service charge
        return super.withdraw(amountToWithdraw + (currentBalance - amountToWithdraw < 150 ? 2 : 0));

    }
}
