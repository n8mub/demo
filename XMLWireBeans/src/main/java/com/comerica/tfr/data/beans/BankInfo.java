package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BankInfo")
public class BankInfo {
	
	@XStreamAlias("BankIdType")
	private String bankIdType = "ABA";
	
	@XStreamAlias("BankId")
	private String bankId;
	
	public BankInfo(String bankId, String bankIdType) {
		this.bankId = bankId;
		this.bankIdType = bankIdType;
	}
	
	public BankInfo() {
	}

	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getBankIdType() {
		return bankIdType;
	}
	public void setBankIdType(String bankIdType) {
		this.bankIdType = bankIdType;
	}
}
