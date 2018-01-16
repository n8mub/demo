package demo.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@Entity
@Table(name="DEMO_CUSTOMERS")
public class Customer implements Serializable, Comparable<Customer> {
	
	public static final String CUSTOMER_ID = "CUSTOMER_ID";
	public static final String CUST_FIRST_NAME = "CUST_FIRST_NAME";
	public static final String CUST_LAST_NAME = "CUST_LAST_NAME";
	public static final String CUST_STREET_ADDRESS1 = "CUST_STREET_ADDRESS1";
	public static final String CUST_STREET_ADDRESS2 = "CUST_STREET_ADDRESS2";
	public static final String CUST_CITY = "CUST_CITY";
	public static final String CUST_STATE = "CUST_STATE";
	public static final String CUST_POSTAL_CODE = "CUST_POSTAL_CODE";
	public static final String PHONE_NUMBER1 = "PHONE_NUMBER1";
	public static final String PHONE_NUMBER2 = "PHONE_NUMBER2";
	public static final String CREDIT_LIMIT = "CREDIT_LIMIT";
	public static final String CUST_EMAIL = "CUST_EMAIL";
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name="CUSTOMER_ID")
	private Integer customerID;
	@Column(name="CUST_FIRST_NAME",length=20)
	private String firstName;
	@Column(name="CUST_LAST_NAME",length=20)
	private String lastName;
	@Column(name="CUST_STREET_ADDRESS1",length=60)
	private String streetAddress1;
	@Column(name="CUST_STREET_ADDRESS2",length=60)
	private String streetAddress2;
	@Column(name="CUST_CITY",length=30)
	private String city;
	@Column(name="CUST_STATE",length=2)
	private String state;
	@Column(name="CUST_POSTAL_CODE",length=10)
	private String postalCode;
	@Column(name="PHONE_NUMBER1",length=25)
	private String phoneNumber1;
	@Column(name="PHONE_NUMBER2",length=25)
	private String phoneNumber2;
	@Column(name="CREDIT_LIMIT",precision=9,scale=2)
	private BigDecimal creditLimit;
	@Column(name="CUST_EMAIL",length=30)
	private String email;

	public Customer() {
		
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Order.class)
	@JoinColumn(name="CUSTOMER_ID")
	private SortedSet<Order> ordersList;
	
	@SuppressWarnings("unchecked")
	public SortedSet<Order> getOrdersList() {
		if(ordersList == null){
			ordersList = new TreeSet<Order>();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Order.class);
			criteria.add(Restrictions.eq("order.customerID", this.customerID));
			ordersList.addAll((List<Order>) criteria.list());
			session.close();
		}
		return ordersList;
	}

	@Override
	public int compareTo(Customer customer) {
		if(customer == null){
			return -1;
		}
		// TODO Auto-generated method stub
		return this.customerID.compareTo(customer.customerID);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer){
			Customer customer = (Customer) obj;
			return this.customerID.equals(customer.customerID);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Customer.class.getName()).append(System.lineSeparator());
		builder.append("[customerID = ").append(customerID).append(",").append(System.lineSeparator());
		builder.append("firstName = ").append(firstName).append(",").append(System.lineSeparator());
		builder.append("lastName = ").append(lastName).append(",").append(System.lineSeparator());
		builder.append("streetAddress1 = ").append(streetAddress1).append(",").append(System.lineSeparator());
		builder.append("streetAddress2 = ").append(streetAddress2).append(",").append(System.lineSeparator());
		builder.append("city = ").append(city).append(",").append(System.lineSeparator());
		builder.append("state = ").append(state).append(",").append(System.lineSeparator());
		builder.append("postalCode = ").append(postalCode).append(",").append(System.lineSeparator());
		builder.append("phoneNumber1 = ").append(phoneNumber1).append(",").append(System.lineSeparator());
		builder.append("phoneNumber2 = ").append(phoneNumber2).append(",").append(System.lineSeparator());
		builder.append("creditLimit = ").append(creditLimit).append(",").append(System.lineSeparator());
		builder.append("email = ").append(email).append("]");
		return builder.toString();
	}
	
	

}
