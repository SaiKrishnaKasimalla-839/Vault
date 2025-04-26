package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int investment_id;
    private String investor_name;
    private String investor_email;
    private String accountNo;
    private String investmentType;      
    private double amountInvested;
    private String investmentDate;      
    private String maturityDate;        
    private double expectedReturnRate;  
    private boolean isActive;
    private String riskLevel;           
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvestment_id() {
		return investment_id;
	}
	public void setInvestment_id(int investment_id) {
		this.investment_id = investment_id;
	}
	public String getInvestor_name() {
		return investor_name;
	}
	public void setInvestor_name(String investor_name) {
		this.investor_name = investor_name;
	}
	public String getInvestor_email() {
		return investor_email;
	}
	public void setInvestor_email(String investor_email) {
		this.investor_email = investor_email;
	}
	public String getInvestmentType() {
		return investmentType;
	}
	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}
	public double getAmountInvested() {
		return amountInvested;
	}
	public void setAmountInvested(double amountInvested) {
		this.amountInvested = amountInvested;
	}
	public String getInvestmentDate() {
		return investmentDate;
	}
	public void setInvestmentDate(String investmentDate) {
		this.investmentDate = investmentDate;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	public double getExpectedReturnRate() {
		return expectedReturnRate;
	}
	public void setExpectedReturnRate(double expectedReturnRate) {
		this.expectedReturnRate = expectedReturnRate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	public String getInvestmentStatus() {
		return investmentStatus;
	}
	public void setInvestmentStatus(String investmentStatus) {
		this.investmentStatus = investmentStatus;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	private String investmentStatus;    
    
}
