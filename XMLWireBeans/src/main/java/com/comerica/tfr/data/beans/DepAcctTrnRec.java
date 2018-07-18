package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DepAcctTrnRec")
public class DepAcctTrnRec {
	
	@XStreamAlias("BankAcctTrnRec")
	private BankAcctTrnRec bankAcctTrnRec;

	public DepAcctTrnRec(BankAcctTrnRec bankAcctTrnRec) {
		super();
		this.bankAcctTrnRec = bankAcctTrnRec;
	}

	public BankAcctTrnRec getBankAcctTrnRec() {
		return bankAcctTrnRec;
	}

	public void setBankAcctTrnRec(BankAcctTrnRec bankAcctTrnRec) {
		this.bankAcctTrnRec = bankAcctTrnRec;
	}
}
