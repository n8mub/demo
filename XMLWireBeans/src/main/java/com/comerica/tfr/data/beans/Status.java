package com.comerica.tfr.data.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Status")
public class Status {
	
	@XStreamAlias("StatusCode")
	private String statusCode = Integer.toString(0);
	
	@XStreamAlias("Severity")
	private String severity = "Info";
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
}
