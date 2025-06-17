package com.techelevator;

import java.util.ArrayList;
import java.util.List;
public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts;

    //Constructor
    public BankCustomer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>(); //initialize the accounts list
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[0]);
    }
    public void addAccount(Accountable newAccount) {
            accounts.add(newAccount);

    }

    // method to check if the customer is a VIP
    public boolean isVip() {
        int totalBalance = 0;

        // sum up the balances of all accounts
        for( Accountable account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance >= 25000;
    }
}
