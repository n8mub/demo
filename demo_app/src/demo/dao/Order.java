package demo.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.SortedSet;
import java.util.TreeSet;

public class Order implements Comparable<Order> {
	private Integer orderID;
	private Integer customerID;
	private BigDecimal orderTotal;
	private Timestamp orderTimestamp;
	private Integer userID;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Timestamp getOrderTimestamp() {
		return orderTimestamp;
	}

	public void setOrderTimestamp(Timestamp orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public Customer getParentCustomer() {
		Customer customer = new Customer();
		// TODO Auto-generated method stub
		return customer;
	}
	
	private SortedSet<OrderItem> orderItemsList;
	
	public SortedSet<OrderItem> getOderItemList() {
		if(orderItemsList == null){
			orderItemsList = new TreeSet<OrderItem>();
			// TODO Auto-generated method stub
		}
		return orderItemsList;
	}

	@Override
	public int compareTo(Order order) {
		if(order == null){
			return -1;
		}
		return this.orderID.compareTo(order.orderID);
	}

}
