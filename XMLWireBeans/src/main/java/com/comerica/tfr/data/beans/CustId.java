package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CustId")
public class CustId {
	
	@XStreamAlias("SPName")
	private String spName = "Comerica";
	
	@XStreamAlias("CustPermId")
	private String custPermId;

	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public String getCustPermId() {
		return custPermId;
	}
	public void setCustPermId(String custPermId) {
		this.custPermId = custPermId;
	}
}
