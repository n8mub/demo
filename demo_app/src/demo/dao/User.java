package demo.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable, Comparable<User> {
	
	private static final long serialVersionUID = -8546411695500055278L;
	private Integer userID;
	private String userName;
	private String password;
	private Timestamp createdOnDt;
	private Integer quota;
	private Boolean productsFL;
	private Timestamp expiresOnDt;
	private Boolean adminUserFL;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedOnDt() {
		return createdOnDt;
	}

	public void setCreatedOnDt(Timestamp createdOnDt) {
		this.createdOnDt = createdOnDt;
	}

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
		this.quota = quota;
	}

	public Boolean getProductsFL() {
		return productsFL;
	}

	public void setProductsFL(Boolean productsFL) {
		this.productsFL = productsFL;
	}

	public Timestamp getExpiresOnDt() {
		return expiresOnDt;
	}

	public void setExpiresOnDt(Timestamp expiresOnDt) {
		this.expiresOnDt = expiresOnDt;
	}

	public Boolean getAdminUserFL() {
		return adminUserFL;
	}

	public void setAdminUserFL(Boolean adminUserFL) {
		this.adminUserFL = adminUserFL;
	}

	@Override
	public int compareTo(User user) {
		if(user == null){
			return -1;
		}
		return this.userID.compareTo(user.userID);
	}

}
