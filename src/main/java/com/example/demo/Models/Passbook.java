package com.example.demo.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passbook {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public Passbook(String senderAccount, String receiverAccount, double amount, LocalDateTime timestamp,
			String transactionType) {
		super();
		this.senderAccount = senderAccount;
		this.receiverAccount = receiverAccount;
		this.amount = amount;
		this.timestamp = timestamp;
		this.transactionType = transactionType;
	}
	public Passbook() {
		
	}
	private String senderAccount;
    private String receiverAccount;
    private double amount;
    private LocalDateTime timestamp;
    private String transactionType;
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
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
