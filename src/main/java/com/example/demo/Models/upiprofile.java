package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class upiprofile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mobilenumber;
	private String setupipin;
	private String accountNo;
	private String setupid;
	public String getSetupid() {
		return setupid;
	}
	public void setSetupid(String setupid) {
		this.setupid = setupid;
	}
	private String setlockpin;
	public String getSetlockpin() {
		return setlockpin;
	}
	public void setSetlockpin(String setlockpin) {
		this.setlockpin = setlockpin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getSetupipin() {
		return setupipin;
	}
	public void setSetupipin(String setupipin) {
		this.setupipin = setupipin;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	}
