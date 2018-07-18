package com.comerica.tfr.notify.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.comerica.tfr.commons.exception.TFRException;
import com.comerica.tfr.data.beans.ProcessedReportDataBean;
import com.comerica.tfr.data.enums.ReportStatusEnum;
import com.comerica.tfr.notify.bean.NotificationBean;

public class NotifyServiceImpl implements NotifyService {
	
	private List<NotificationBean> notifications = new ArrayList<NotificationBean>();
	private Map<String, ProcessedReportDataBean> reports = new HashMap<String, ProcessedReportDataBean>();

	public void addNotifications(NotificationBean... notifications) throws TFRException {
		if(!this.notifications.addAll(Arrays.asList(notifications))) {
			System.err.println("Exception in addNotifications:");
			throw new TFRException("Exception in addNotifications:");
		}
	}

	public void saveReportFile(ProcessedReportDataBean processedReportDataBean) throws TFRException {
		System.out.println("Started async saveReportFile in thread " + Thread.currentThread().getName());
		Long processedReportID = processedReportDataBean.getProcessedReportId();
		String reportContent = Long.toString(processedReportID);
		if (ReportStatusEnum.READY.getReportStatus().equalsIgnoreCase(processedReportDataBean.getReportStatus())) {
			if (StringUtils.isNotBlank(reportContent)) {
				
			} else {
				reportContent = "00" + reports.size();
				System.out.println("No Report Content retrieved for processed report id: " + processedReportID);
			}
		}
		if(reports.containsKey(reportContent)) {
			reports.get(reportContent).setReportStatus(processedReportDataBean.getReportStatus());
		} else {
			reports.put(reportContent, processedReportDataBean);
		}
	}

}
