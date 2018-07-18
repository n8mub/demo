package com.comerica.tfr.notify.service;

import com.comerica.tfr.commons.exception.TFRException;
import com.comerica.tfr.data.beans.ProcessedReportDataBean;
import com.comerica.tfr.notify.bean.NotificationBean;


public interface NotifyService {

	void addNotifications(final NotificationBean... notifications) throws TFRException;

    void saveReportFile(ProcessedReportDataBean processedReportDataBean) throws TFRException;
}
