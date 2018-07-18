package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BankSvcRs")
public class BankSvcRs {
	
	@XStreamAlias("Status")
	private Status status;
	
	@XStreamAlias("RqUID")
	private String rqUID;
	
	@XStreamAlias("DepAcctTrnInqRs")
	private DepAcctTrnInqRs depAcctTrnInqRs;
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getRqUID() {
		return rqUID;
	}
	public void setRqUID(String rqUID) {
		this.rqUID = rqUID;
	}
	public DepAcctTrnInqRs getDepAcctTrnInqRs() {
		return depAcctTrnInqRs;
	}
	public void setDepAcctTrnInqRs(DepAcctTrnInqRs depAcctTrnInqRs) {
		this.depAcctTrnInqRs = depAcctTrnInqRs;
	}
}
