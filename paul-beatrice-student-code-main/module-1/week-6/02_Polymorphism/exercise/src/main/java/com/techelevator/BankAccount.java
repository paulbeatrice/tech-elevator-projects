package com.techelevator;

public class BankAccount implements Accountable {

    private final String accountIdentifier;
    private int balance;

    //Existing methods ( e.g., withdraw, deposit)

    //introduce method to transfer funds
    public int transferFunds(BankAccount destinationAccount, int amountToTransfer) {
        //Check the balance to make sure there is enough to transfer
        if (amountToTransfer > balance) {
            System.out.println("Insufficient balance for transfer.");
            return balance; //return current balance with no changes
        }
        //withdraw from the current account
        withdraw(amountToTransfer);

        //deposit to the destination account
        destinationAccount.deposit(amountToTransfer);

        //return the new balance of the current account
        return balance;
    }

    public BankAccount(String accountIdentifier, int startingBalance) {
        this.accountIdentifier = accountIdentifier;
        balance = startingBalance;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    /**
     * Deposits the specified amount into the bank account.
     *
     * @param amountToDeposit the amount to deposit
     */
    public void deposit(int amountToDeposit) {
        if (amountToDeposit > 0) {
            balance = balance + amountToDeposit;
        }
    }

    /**
     * Withdraws the specified amount from the bank account.
     *
     * @param amountToWithdraw the amount to withdraw from the account
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdraw(int amountToWithdraw) {
        if (amountToWithdraw > 0 && balance - amountToWithdraw >= 0) {
            balance = balance - amountToWithdraw;
            return true;
        }
        return false;
    }


}
