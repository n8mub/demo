package demo.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@Entity
@Table(name = "DEMO_ORDERS")
public class Order implements Serializable, Comparable<Order> {

	public static final String ORDER_ID = "ORDER_ID";
	public static final String CUSTOMER_ID = "CUSTOMER_ID";
	public static final String ORDER_TOTAL = "ORDER_TOTAL";
	public static final String ORDER_TIMESTAMP = "ORDER_TIMESTAMP";
	public static final String USER_ID = "USER_ID";

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Integer orderID;
	@Column(name = "CUSTOMER_ID")
	private Integer customerID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID", table = "DEMO_CUSTOMERS")
	private Customer customer;
	@Column(name = "ORDER_TOTAL", precision = 8, scale = 2)
	private BigDecimal orderTotal;
	@Column(name = "ORDER_TIMESTAMP")
	private Timestamp orderTimestamp;
	@Column(name = "USER_ID")
	private Integer userID;

	public Order() {
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
		if (customer == null) {
			Session session = DBUtil.getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.add(Restrictions.eq("customerID", this.getCustomerID()));
			customer = (Customer) criteria.uniqueResult();
		}
		return customer;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = OrderItem.class)
	@JoinColumn(name = "ORDER_ID", table = "DEMO_ORDER_ITEMS")
	private SortedSet<OrderItem> orderItemsList;

	@SuppressWarnings("unchecked")
	public SortedSet<OrderItem> getOderItemList() {
		if (orderItemsList == null) {
			try {
				orderItemsList = new TreeSet<OrderItem>();
				Session session = DBUtil.getSessionFactory().getCurrentSession();
				Criteria criteria = session.createCriteria(OrderItem.class);
				criteria.add(Restrictions.eq("orderID", this.getOrderID()));
				orderItemsList.addAll((List<OrderItem>) criteria.list());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return orderItemsList;
	}

	private SortedSet<ProductInfo> productList;

	public SortedSet<ProductInfo> getProductList() {
		if (productList == null) {
			productList = new TreeSet<ProductInfo>();
			getOderItemList().stream().forEach(orderItem -> productList.add(orderItem.getParentProductInfo()));
		}
		return productList;
	}

	@Override
	public int compareTo(Order order) {
		if (order == null) {
			return -1;
		}
		return this.orderID.compareTo(order.orderID);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getName()).append(System.lineSeparator());
		builder.append("[orderID = ").append(orderID).append(",").append(System.lineSeparator());
		builder.append("[customerID = ").append(customerID).append(",").append(System.lineSeparator());
		builder.append("orderTotal = ").append(orderTotal).append(",").append(System.lineSeparator());
		builder.append("orderTimestamp = ").append(orderTimestamp).append(",").append(System.lineSeparator());
		builder.append("userID = ").append(userID).append("]");
		return builder.toString();
	}

}
