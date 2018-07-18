package com.comerica.tfr.data.enums;

public enum ReportStatusEnum {
	
	READY("Ready"),
	PROCESSING("Processing"),
	PROCESSED("Processed"),
	FAILED("Failed"),
	SENT("Sent"),
	SENDING("Sending");

	private final String reportStatus;
	
	ReportStatusEnum(final String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getReportStatus() {
		return reportStatus;
	}

}
