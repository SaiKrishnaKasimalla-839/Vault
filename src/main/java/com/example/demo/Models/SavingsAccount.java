package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SavingsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String setaccountHolderName;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSetaccountHolderName() {
		return setaccountHolderName;
	}
	public void setSetaccountHolderName(String setaccountHolderName) {
		this.setaccountHolderName = setaccountHolderName;
	}
	public String getSetaccountNumber() {
		return setaccountNumber;
	}
	public void setSetaccountNumber(String setaccountNumber) {
		this.setaccountNumber = setaccountNumber;
	}
	public String getSetemail() {
		return setemail;
	}
	public void setSetemail(String setemail) {
		this.setemail = setemail;
	}
	public String getSetphoneNumber() {
		return setphoneNumber;
	}
	public void setSetphoneNumber(String setphoneNumber) {
		this.setphoneNumber = setphoneNumber;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	private String setaccountNumber;
    private String setemail;
    private String setphoneNumber;
    private String branch;               
    private String ifscCode;
}
