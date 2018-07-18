package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BankAcctTrnRec")
public class BankAcctTrnRec {
	
	@XStreamAlias("TrnType")
	private String trnType;
	
	@XStreamAlias("PostedDt")
	private String postedDt;
	
	@XStreamAlias("CurAmt")
	private CurAmt curAmt;
	
	@XStreamAlias("NetworkRefId")
	private String networkRefId;
	
	@XStreamAlias("SendingBank")
	private String sendingBank;
	
	@XStreamAlias("SendingBankReference")
	private String sendingBankReference;
	
	@XStreamAlias("ReceivingBank")
	private String receivingBank;
	
	@XStreamAlias("WireAmt")
	private WireAmt wireAmt;
	
	@XStreamAlias("RateApplied")
	private String rateApplied;
	
	@XStreamAlias("IntermediaryBank")
	private String intermediaryBank;
	
	@XStreamAlias("BeneficiaryBank")
	private String beneficiaryBank;
	
	@XStreamAlias("Beneficiary")
	private String beneficiary;
	
	@XStreamAlias("ReferenceForBeneficiary")
	private String referenceForBeneficiary;
	
	@XStreamAlias("Originator")
	private String originator;
	
	@XStreamAlias("OriginatingBank")
	private String originatingBank;
	
	@XStreamAlias("OriginatorsBank")
	private String originatorsBank;
	
	@XStreamAlias("InstructingBank")
	private String instructingBank;
	
	@XStreamAlias("SendingBanksCorrespondent")
	private String sendingBanksCorrespondent;
	
	@XStreamAlias("ReceivingBanksCorrespondent")
	private String receivingBanksCorrespondent;
	
	@XStreamAlias("OriginatorToBeneficiaryInfo")
	private String originatorToBeneficiaryInfo;
	
	@XStreamAlias("DetailOfCharges")
	private String detailOfCharges;
	
	@XStreamAlias("ReceivingBankInfo")
	private String receivingBankInfo;
	
	@XStreamAlias("IntermediaryBankInfo")
	private String intermediaryBankInfo;
	
	@XStreamAlias("IntermediaryBankAdviceInfo")
	private String intermediaryBankAdviceInfo;
	
	@XStreamAlias("BeneficiaryBankInfo")
	private String beneficiaryBankInfo;
	
	@XStreamAlias("BeneficiaryBankAdviceInfo")
	private String beneficiaryBankAdviceInfo;
	
	@XStreamAlias("BeneficiaryMethodOfPayment")
	private String beneficiaryMethodOfPayment;
	
	@XStreamAlias("BeneficiaryInfo")
	private String beneficiaryInfo;
	
	@XStreamAlias("BeneficiaryAdviceInfo")
	private String beneficiaryAdviceInfo;
	
	@XStreamAlias("InstructionCode")
	private String instructionCode;
	
	@XStreamAlias("BankToBankInfo")
	private String bankToBankInfo;
	
	@XStreamAlias("Amount")
	private String amount;
	
	@XStreamAlias("AcceptanceTimestamp")
	private String acceptanceTimestamp;
	
	@XStreamAlias("OMADInfo")
	private String omadInfo;
	
	@XStreamAlias("IMADInfo")
	private String imadInfo;
	
	@XStreamAlias("Addenda")
	private String addenda;
	
	@XStreamAlias("AccountDebitedInDrawdown")
	private String accountDebitedInDrawdown;
	
	@XStreamAlias("AccountCreditedInDrawdown")
	private String accountCreditedInDrawdown;
	
	@XStreamAlias("DrawdownDebitAccountAdviceInfo")
	private String drawdownDebitAccountAdviceInfo;
	
	@XStreamAlias("FreeformText")
	private String freeformText;
	
	@XStreamAlias("Charges")
	private String charges;
	
	@XStreamAlias("InstructedAmount")
	private String instructedAmount;
	
	@XStreamAlias("ExhangeRate")
	private String exchangeRate;
	
	@XStreamAlias("PaymentLimitations")
	private String paymentLimitations;
	
	@XStreamAlias("OutgoingTimestamp")
	private String outgoingTimestamp;
	
	public String getTrnType() {
		return trnType;
	}
	public void setTrnType(String trnType) {
		this.trnType = trnType;
	}
	public String getPostedDt() {
		return postedDt;
	}
	public void setPostedDt(String postedDt) {
		this.postedDt = postedDt;
	}
	public CurAmt getCurAmt() {
		return curAmt;
	}
	public void setCurAmt(CurAmt curAmt) {
		this.curAmt = curAmt;
	}
	public String getNetworkRefId() {
		return networkRefId;
	}
	public void setNetworkRefId(String networkRefId) {
		this.networkRefId = networkRefId;
	}
	public String getSendingBank() {
		return sendingBank;
	}
	public void setSendingBank(String sendingBank) {
		this.sendingBank = sendingBank;
	}
	public String getSendingBankReference() {
		return sendingBankReference;
	}
	public void setSendingBankReference(String sendingBankReference) {
		this.sendingBankReference = sendingBankReference;
	}
	public String getReceivingBank() {
		return receivingBank;
	}
	public void setReceivingBank(String receivingBank) {
		this.receivingBank = receivingBank;
	}
	public WireAmt getWireAmt() {
		return wireAmt;
	}
	public void setWireAmt(WireAmt wireAmt) {
		this.wireAmt = wireAmt;
	}
	public String getRateApplied() {
		return rateApplied;
	}
	public void setRateApplied(String rateApplied) {
		this.rateApplied = rateApplied;
	}
	public String getIntermediaryBank() {
		return intermediaryBank;
	}
	public void setIntermediaryBank(String intermediaryBank) {
		this.intermediaryBank = intermediaryBank;
	}
	public String getBeneficiaryBank() {
		return beneficiaryBank;
	}
	public void setBeneficiaryBank(String beneficiaryBank) {
		this.beneficiaryBank = beneficiaryBank;
	}
	public String getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}
	public String getReferenceForBeneficiary() {
		return referenceForBeneficiary;
	}
	public void setReferenceForBeneficiary(String referenceForBeneficiary) {
		this.referenceForBeneficiary = referenceForBeneficiary;
	}
	public String getOriginator() {
		return originator;
	}
	public void setOriginator(String originator) {
		this.originator = originator;
	}
	public String getOriginatingBank() {
		return originatingBank;
	}
	public void setOriginatingBank(String originatingBank) {
		this.originatingBank = originatingBank;
	}
	public String getOriginatorsBank() {
		return originatorsBank;
	}
	public void setOriginatorsBank(String originatorsBank) {
		this.originatorsBank = originatorsBank;
	}
	public String getInstructingBank() {
		return instructingBank;
	}
	public void setInstructingBank(String instructingBank) {
		this.instructingBank = instructingBank;
	}
	public String getSendingBanksCorrespondent() {
		return sendingBanksCorrespondent;
	}
	public void setSendingBanksCorrespondent(String sendingBanksCorrespondent) {
		this.sendingBanksCorrespondent = sendingBanksCorrespondent;
	}
	public String getReceivingBanksCorrespondent() {
		return receivingBanksCorrespondent;
	}
	public void setReceivingBanksCorrespondent(String receivingBanksCorrespondent) {
		this.receivingBanksCorrespondent = receivingBanksCorrespondent;
	}
	public String getOriginatorToBeneficiaryInfo() {
		return originatorToBeneficiaryInfo;
	}
	public void setOriginatorToBeneficiaryInfo(String originatorToBeneficiaryInfo) {
		this.originatorToBeneficiaryInfo = originatorToBeneficiaryInfo;
	}
	public String getDetailOfCharges() {
		return detailOfCharges;
	}
	public void setDetailOfCharges(String detailOfCharges) {
		this.detailOfCharges = detailOfCharges;
	}
	public String getReceivingBankInfo() {
		return receivingBankInfo;
	}
	public void setReceivingBankInfo(String receivingBankInfo) {
		this.receivingBankInfo = receivingBankInfo;
	}
	public String getIntermediaryBankInfo() {
		return intermediaryBankInfo;
	}
	public void setIntermediaryBankInfo(String intermediaryBankInfo) {
		this.intermediaryBankInfo = intermediaryBankInfo;
	}
	public String getIntermediaryBankAdviceInfo() {
		return intermediaryBankAdviceInfo;
	}
	public void setIntermediaryBankAdviceInfo(String intermediaryBankAdviceInfo) {
		this.intermediaryBankAdviceInfo = intermediaryBankAdviceInfo;
	}
	public String getBeneficiaryBankInfo() {
		return beneficiaryBankInfo;
	}
	public void setBeneficiaryBankInfo(String beneficiaryBankInfo) {
		this.beneficiaryBankInfo = beneficiaryBankInfo;
	}
	public String getBeneficiaryBankAdviceInfo() {
		return beneficiaryBankAdviceInfo;
	}
	public void setBeneficiaryBankAdviceInfo(String beneficiaryBankAdviceInfo) {
		this.beneficiaryBankAdviceInfo = beneficiaryBankAdviceInfo;
	}
	public String getBeneficiaryMethodOfPayment() {
		return beneficiaryMethodOfPayment;
	}
	public void setBeneficiaryMethodOfPayment(String beneficiaryMethodOfPayment) {
		this.beneficiaryMethodOfPayment = beneficiaryMethodOfPayment;
	}
	public String getBeneficiaryInfo() {
		return beneficiaryInfo;
	}
	public void setBeneficiaryInfo(String beneficiaryInfo) {
		this.beneficiaryInfo = beneficiaryInfo;
	}
	public String getBeneficiaryAdviceInfo() {
		return beneficiaryAdviceInfo;
	}
	public void setBeneficiaryAdviceInfo(String beneficiaryAdviceInfo) {
		this.beneficiaryAdviceInfo = beneficiaryAdviceInfo;
	}
	public String getInstructionCode() {
		return instructionCode;
	}
	public void setInstructionCode(String instructionCode) {
		this.instructionCode = instructionCode;
	}
	public String getBankToBankInfo() {
		return bankToBankInfo;
	}
	public void setBankToBankInfo(String bankToBankInfo) {
		this.bankToBankInfo = bankToBankInfo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAcceptanceTimestamp() {
		return acceptanceTimestamp;
	}
	public void setAcceptanceTimestamp(String acceptanceTimestamp) {
		this.acceptanceTimestamp = acceptanceTimestamp;
	}
	public String getOmadInfo() {
		return omadInfo;
	}
	public void setOmadInfo(String omadInfo) {
		this.omadInfo = omadInfo;
	}
	public String getImadInfo() {
		return imadInfo;
	}
	public void setImadInfo(String imadInfo) {
		this.imadInfo = imadInfo;
	}
	public String getAddenda() {
		return addenda;
	}
	public void setAddenda(String addenda) {
		this.addenda = addenda;
	}
	public String getAccountDebitedInDrawdown() {
		return accountDebitedInDrawdown;
	}
	public void setAccountDebitedInDrawdown(String accountDebitedInDrawdown) {
		this.accountDebitedInDrawdown = accountDebitedInDrawdown;
	}
	public String getAccountCreditedInDrawdown() {
		return accountCreditedInDrawdown;
	}
	public void setAccountCreditedInDrawdown(String accountCreditedInDrawdown) {
		this.accountCreditedInDrawdown = accountCreditedInDrawdown;
	}
	public String getDrawdownDebitAccountAdviceInfo() {
		return drawdownDebitAccountAdviceInfo;
	}
	public void setDrawdownDebitAccountAdviceInfo(String drawdownDebitAccountAdviceInfo) {
		this.drawdownDebitAccountAdviceInfo = drawdownDebitAccountAdviceInfo;
	}
	public String getFreeformText() {
		return freeformText;
	}
	public void setFreeformText(String freeformText) {
		this.freeformText = freeformText;
	}
	public String getCharges() {
		return charges;
	}
	public void setCharges(String charges) {
		this.charges = charges;
	}
	public String getInstructedAmount() {
		return instructedAmount;
	}
	public void setInstructedAmount(String instructedAmount) {
		this.instructedAmount = instructedAmount;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getPaymentLimitations() {
		return paymentLimitations;
	}
	public void setPaymentLimitations(String paymentLimitations) {
		this.paymentLimitations = paymentLimitations;
	}
	public String getOutgoingTimestamp() {
		return outgoingTimestamp;
	}
	public void setOutgoingTimestamp(String outgoingTimestamp) {
		this.outgoingTimestamp = outgoingTimestamp;
	}
	
	
}
