package com.techelevator;

public class CheckingAccount extends BankAccount {

    //Constructor that calls the parent constructor
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    //Override the withdraw method with additional rules
    @Override
    public int withdraw(int amountToWithdraw) {
        int currentBalance = getBalance();
        int newBalance = currentBalance - amountToWithdraw;

        //Rule 2: Deny withdraw if new balance would be -$100 or less
        if (newBalance <= -100) {
            return getBalance(); //return current balance without any changes
        }

        // Rule 1: Apply Overdraft fee if balance goes negative but remains above -$100
        if (newBalance < 0) {
            amountToWithdraw += 10; // Apply $10 overdraft fee
        }

        //Set balance to the newly calculated balance and return it
        return super.withdraw(amountToWithdraw);
    }
}
