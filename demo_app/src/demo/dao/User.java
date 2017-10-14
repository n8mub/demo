package demo.dao;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEMO_USERS")
public class User implements Serializable, Comparable<User> {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name="USER_ID")
	private Integer userID;
	@Column(name="USER_NAME",length=100)
	private String userName;
	@Column(name="PASSWORD",length=4000)
	private String password;
	@Column(name="CREATED_ON")
	private Timestamp createdOnDt;
	@Column(name="QUOTA")
	private Integer quota;
	@Column(name="PRODUCTS")
	private Boolean productsFL;
	@Column(name="EXPIRES_ON")
	private Timestamp expiresOnDt;
	@Column(name="ADMIN_USER")
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
