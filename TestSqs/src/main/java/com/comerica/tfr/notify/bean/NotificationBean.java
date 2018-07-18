package com.comerica.tfr.notify.bean;

import java.util.ArrayList;
import java.util.List;

import com.comerica.tfr.data.beans.AccountBean;

public class NotificationBean {

	private Long unitOfWorkId;
	private String fileId;
	private List<AccountBean> accounts = new ArrayList<AccountBean>();

	public Long getUnitOfWorkId() {
		return unitOfWorkId;
	}

	public void setUnitOfWorkId(Long unitOfWorkId) {
		this.unitOfWorkId = unitOfWorkId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public List<AccountBean> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountBean> accounts) {
		this.accounts = accounts;
	}

}
