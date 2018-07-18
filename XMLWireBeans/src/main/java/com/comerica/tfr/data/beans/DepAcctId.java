package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DepAcctId")
public class DepAcctId {
	
	@XStreamAlias("AcctId")
	private String acctId;
	
	@XStreamAlias("AcctType")
	private String acctType = "DDA";
	
	@XStreamAlias("BankInfo")
	private BankInfo bankInfo;
	
	public DepAcctId(String acctId, String acctType, BankInfo bankInfo) {
		this.acctId = acctId;
		this.acctType = acctType;
		this.bankInfo = bankInfo;
	}
	
	public DepAcctId() {
	}

	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public BankInfo getBankInfo() {
		return bankInfo;
	}
	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}
}
