package com.comerica.tfr.data.beans;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("CMA")
public class CMA {
	
	@XStreamImplicit
	private List<BankSvcRs> bankSvcRs;

	public List<BankSvcRs> getBankSvcRs() {
		return bankSvcRs;
	}

	public void setBankSvcRs(List<BankSvcRs> bankSvcRs) {
		this.bankSvcRs = bankSvcRs;
	}
}
