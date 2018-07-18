package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DepAcctTrnInqRs")
public class DepAcctTrnInqRs {
	
	@XStreamAlias("RqUID")
	private String rqUID;
	
	@XStreamAlias("CustId")
	private CustId custId;
	
	@XStreamAlias("DepAcctId")
	private DepAcctId depAcctId;
	
	@XStreamAlias("DepAcctTrnRec")
	private DepAcctTrnRec depAcctTrnRec;
	
	public String getRqUID() {
		return rqUID;
	}
	public void setRqUID(String rqUID) {
		this.rqUID = rqUID;
	}
	public CustId getCustId() {
		return custId;
	}
	public void setCustId(CustId custId) {
		this.custId = custId;
	}
	public DepAcctId getDepAcctId() {
		return depAcctId;
	}
	public void setDepAcctId(DepAcctId depAcctId) {
		this.depAcctId = depAcctId;
	}
	public DepAcctTrnRec getDepAcctTrnRec() {
		return depAcctTrnRec;
	}
	public void setDepAcctTrnRec(DepAcctTrnRec depAcctTrnRec) {
		this.depAcctTrnRec = depAcctTrnRec;
	}
}
