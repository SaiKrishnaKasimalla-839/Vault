package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DebitCard {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String accountNo;
private String email;
private String createName;
private String createCardNumber;
private String setPin;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAccountNo() {
	return accountNo;
}
public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCreateName() {
	return createName;
}
public void setCreateName(String createName) {
	this.createName = createName;
}
public String getCreateCardNumber() {
	return createCardNumber;
}
public void setCreateCardNumber(String createCardNumber) {
	this.createCardNumber = createCardNumber;
}
public String getSetPin() {
	return setPin;
}
public void setSetPin(String setPin) {
	this.setPin = setPin;
}
}
