package com.hcl.FundTransfer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private long accountNo;
	private int userId;
	private long amount;
	//private String  acccountType;
	
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	/*public String getAcccountType() {
		return acccountType;
	}
	public void setAcccountType(String acccountType) {
		this.acccountType = acccountType;
	}*/
	
}
