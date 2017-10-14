package demo.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DEMO_CUSTOMERS")
public class Customer implements Serializable, Comparable<Customer> {
	
	private static final long serialVersionUID = 1L;
	private Integer customerID;
	private String firstName;
	private String lastName;
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String postalCode;
	private String phoneNumber1;
	private String phoneNumber2;
	private BigDecimal creditLimit;
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
	
	private SortedSet<Order> ordersList;
	
	public SortedSet<Order> getOrdersList() {
		if(ordersList == null){
			ordersList = new TreeSet<Order>();
		}
		// TODO Auto-generated method stub
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

}
