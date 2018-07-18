package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("WireAmmt")
public class WireAmt {
	
	@XStreamAlias("Amt")
	private String amt;
	
	@XStreamAlias("CurCode")
	private String curCode;
	
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getCurCode() {
		return curCode;
	}
	public void setCurCode(String curCode) {
		this.curCode = curCode;
	}
}
