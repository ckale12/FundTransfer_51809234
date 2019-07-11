package com.hcl.FundTransfer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	
	private int userId;
	private long senderAccountNo;
	private String accountType;
	private long receiverAccountNo;
	private long amount;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getSenderAccountNo() {
		return senderAccountNo;
	}
	public void setSenderAccountNo(long senderAccountNo) {
		this.senderAccountNo = senderAccountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getReceiverAccountNo() {
		return receiverAccountNo;
	}
	public void setReceiverAccountNo(long receiverAccountNo) {
		this.receiverAccountNo = receiverAccountNo;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}
