package com.comerica.tfr.data.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessedReportDataBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3172703173130643347L;
	private Long processedReportId;
	private String type;
	private String notifyCallbackURL;
	private String reportStatus;
	private String reportFormat;

	public Long getProcessedReportId() {
		return processedReportId;
	}

	public void setProcessedReportId(Long processedReportId) {
		this.processedReportId = processedReportId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotifyCallbackURL() {
		return notifyCallbackURL;
	}

	public void setNotifyCallbackURL(String notifyCallbackURL) {
		this.notifyCallbackURL = notifyCallbackURL;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getReportFormat() {
		return reportFormat;
	}

	public void setReportFormat(String reportFormat) {
		this.reportFormat = reportFormat;
	}
	
}