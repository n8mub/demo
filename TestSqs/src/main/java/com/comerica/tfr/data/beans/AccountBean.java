package com.comerica.tfr.data.beans;

public class AccountBean {

	private String accountNumber;
	private String abaRoutingNumber;
	private String senderSwiftAddress;
	private String receiverSwiftAddress;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAbaRoutingNumber() {
		return abaRoutingNumber;
	}

	public void setAbaRoutingNumber(String abaRoutingNumber) {
		this.abaRoutingNumber = abaRoutingNumber;
	}

	public String getSenderSwiftAddress() {
		return senderSwiftAddress;
	}

	public void setSenderSwiftAddress(String senderSwiftAddress) {
		this.senderSwiftAddress = senderSwiftAddress;
	}

	public String getReceiverSwiftAddress() {
		return receiverSwiftAddress;
	}

	public void setReceiverSwiftAddress(String receiverSwiftAddress) {
		this.receiverSwiftAddress = receiverSwiftAddress;
	}
	
}
