package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int insurance_id;
    @Column(name = "account_no") 
    private String accountNo;
    public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	private String policyNumber;
    private String email;
    private String insuredName;
    private String insuredAddress;
    private String phoneNumber;
    private String insuranceType;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(int insurance_id) {
		this.insurance_id = insurance_id;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredAddress() {
		return insuredAddress;
	}
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getPolicyStartDate() {
		return policyStartDate;
	}
	public void setPolicyStartDate(String policyStartDate) {
		this.policyStartDate = policyStartDate;
	}
	public String getPolicyEndDate() {
		return policyEndDate;
	}
	public void setPolicyEndDate(String policyEndDate) {
		this.policyEndDate = policyEndDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	private double premiumAmount;
    private String policyStartDate;
    private String policyEndDate;
    private boolean isActive;
    private String claimStatus; 

    
}
