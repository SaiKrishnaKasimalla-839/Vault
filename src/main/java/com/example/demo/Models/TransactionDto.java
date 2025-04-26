package com.example.demo.Models;


public class TransactionDto {
    private String senderAccount;
    private String receiverAccount;
    private double amount;

    public TransactionDto() {
    }

    public TransactionDto(String senderAccount, String receiverAccount, double amount) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
    }
    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Optional: toString method for easy debugging/logging
    @Override
    public String toString() {
        return "TransactionRequest{" +
                "senderAccount='" + senderAccount + '\'' +
                ", receiverAccount='" + receiverAccount + '\'' +
                ", amount=" + amount +
                '}';
    }
}

