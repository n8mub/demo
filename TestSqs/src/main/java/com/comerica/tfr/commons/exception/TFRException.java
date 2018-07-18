package com.comerica.tfr.commons.exception;

public class TFRException  extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	public TFRException(String msg) {
		super(msg);
	}

	public TFRException(String msg, String errorCd, Exception e) {
		super(msg, e);
		this.errorCode = errorCd;
	}

	public TFRException(String msg, String errorCd) {
		super(msg);
		this.errorCode = errorCd;
	}

	public TFRException(String msg, Exception e) {
		super(msg, e);
	}

	public void setErrorCode(String errorCd) {
		this.errorCode = errorCd;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
