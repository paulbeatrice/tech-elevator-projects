package com.techelevator;

public class CreditCardAccount  implements Accountable {
    private String accountHolderName;
    private String cardNumber;
    private int debt; // defines the amount the customer owes (default $0)

    //Constructor
    public CreditCardAccount(String accountHolderName, String cardNumber) {
        this.accountHolderName = accountHolderName;
        this.cardNumber = cardNumber;
        this.debt = 0; //default debt to $0 owed
    }
    //Getters for accountHolderName , cardNumber, and Debt

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getDebt() {
        return debt;
    }
    @Override
    public int getBalance() {
        return -debt; // returns debt as a negative value
    }
    public int pay(int amountToPay) {
        if (amountToPay > 0) {
            debt -= amountToPay;
        }
        return debt;
    }
    public int charge(int amountToCharge) {
        if (amountToCharge > 0) {
            debt += amountToCharge;
        }
        return debt;
    }
}
