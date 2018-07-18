package com.comerica.tfr.data.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TransactionFlat {
	private String transactionId;
	private String accountFlatId;
	private String abaRoutingNumber;
	private String typeCode;
	private String currencyId;
	private String transactionAmount;
	private String fundsType;
	private String bankReferenceNumber;
	private String customerReferenceNumber;
	private String checkNumber;
	private String checkNumberNumeric;
	private String textDesc;
	private String immediateAvailabilityAmount;
	private String oneDayAvailabilityAmount;
	private String moreThanOneDayAvailabilityAmount;
	private String valueDate;
	private String customerAccountNumber;
	private String viewDetailCode;
	private String debitAmount;
	private String creditAmount;
	private String fileDate;
	private String createdDate;
	private String transactionTypeId;
	private String transactionTypeDesc;
	private String typeDesc;
	private String creditInd;
	private String debitInd;
	private String inserted;
	private String balanceAmount;
	private String asOfDate;
	private String priorDayInd;
	private String currentDayInd;
	private String unitOfWorkId;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountFlatId() {
		return accountFlatId;
	}
	public void setAccountFlatId(String accountFlatId) {
		this.accountFlatId = accountFlatId;
	}
	public String getAbaRoutingNumber() {
		return abaRoutingNumber;
	}
	public void setAbaRoutingNumber(String abaRoutingNumber) {
		this.abaRoutingNumber = abaRoutingNumber;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getFundsType() {
		return fundsType;
	}
	public void setFundsType(String fundsType) {
		this.fundsType = fundsType;
	}
	public String getBankReferenceNumber() {
		return bankReferenceNumber;
	}
	public void setBankReferenceNumber(String bankReferenceNumber) {
		this.bankReferenceNumber = bankReferenceNumber;
	}
	public String getCustomerReferenceNumber() {
		return customerReferenceNumber;
	}
	public void setCustomerReferenceNumber(String customerReferenceNumber) {
		this.customerReferenceNumber = customerReferenceNumber;
	}
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	public String getCheckNumberNumeric() {
		return checkNumberNumeric;
	}
	public void setCheckNumberNumeric(String checkNumberNumeric) {
		this.checkNumberNumeric = checkNumberNumeric;
	}
	public String getTextDesc() {
		return textDesc;
	}
	public void setTextDesc(String textDesc) {
		this.textDesc = textDesc;
	}
	public String getImmediateAvailabilityAmount() {
		return immediateAvailabilityAmount;
	}
	public void setImmediateAvailabilityAmount(String immediateAvailabilityAmount) {
		this.immediateAvailabilityAmount = immediateAvailabilityAmount;
	}
	public String getOneDayAvailabilityAmount() {
		return oneDayAvailabilityAmount;
	}
	public void setOneDayAvailabilityAmount(String oneDayAvailabilityAmount) {
		this.oneDayAvailabilityAmount = oneDayAvailabilityAmount;
	}
	public String getMoreThanOneDayAvailabilityAmount() {
		return moreThanOneDayAvailabilityAmount;
	}
	public void setMoreThanOneDayAvailabilityAmount(String moreThanOneDayAvailabilityAmount) {
		this.moreThanOneDayAvailabilityAmount = moreThanOneDayAvailabilityAmount;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}
	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}
	public String getViewDetailCode() {
		return viewDetailCode;
	}
	public void setViewDetailCode(String viewDetailCode) {
		this.viewDetailCode = viewDetailCode;
	}
	public String getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(String debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(String transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	public String getTransactionTypeDesc() {
		return transactionTypeDesc;
	}
	public void setTransactionTypeDesc(String transactionTypeDesc) {
		this.transactionTypeDesc = transactionTypeDesc;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getCreditInd() {
		return creditInd;
	}
	public void setCreditInd(String creditInd) {
		this.creditInd = creditInd;
	}
	public String getDebitInd() {
		return debitInd;
	}
	public void setDebitInd(String debitInd) {
		this.debitInd = debitInd;
	}
	public String getInserted() {
		return inserted;
	}
	public void setInserted(String inserted) {
		this.inserted = inserted;
	}
	public String getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(String balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}
	public String getPriorDayInd() {
		return priorDayInd;
	}
	public void setPriorDayInd(String priorDayInd) {
		this.priorDayInd = priorDayInd;
	}
	public String getCurrentDayInd() {
		return currentDayInd;
	}
	public void setCurrentDayInd(String currentDayInd) {
		this.currentDayInd = currentDayInd;
	}
	public String getUnitOfWorkId() {
		return unitOfWorkId;
	}
	public void setUnitOfWorkId(String unitOfWorkId) {
		this.unitOfWorkId = unitOfWorkId;
	}
	public String toString() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
