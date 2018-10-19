package demo.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@Entity
@Table(name = "DEMO_ORDER_ITEMS")
public class OrderItem implements Serializable, Comparable<OrderItem> {

	public static final String ORDER_ITEM_ID = "ORDER_ITEM_ID";
	public static final String ORDER_ID = "ORDER_ID";
	public static final String PRODUCT_ID = "PRODUCT_ID";
	public static final String UNIT_PRICE = "UNIT_PRICE";
	public static final String QUANTITY = "QUANTITY";

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Integer orderItemID;
	@Column(name = "ORDER_ID")
	private Integer orderID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", table = "DEMO_ORDERS")
	private Order order;
	@Column(name = "PRODUCT_ID")
	private Integer productID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", table = "DEMO_PRODUCT_INFO")
	private ProductInfo productInfo;
	@Column(name = "UNIT_PRICE", precision = 8, scale = 2)
	private Double unitPrice;
	@Column(name = "QUANTITY", precision = 8)
	private Integer quantity;

	public OrderItem() {
	}

	public Integer getOrderItemID() {
		return orderItemID;
	}

	public void setOrderItemID(Integer orderItemID) {
		this.orderItemID = orderItemID;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getParentOrder() {
		if (order == null) {
			try {
				Session session = DBUtil.getSessionFactory().getCurrentSession();
				Criteria criteria = session.createCriteria(Order.class);
				criteria.add(Restrictions.eq("orderID", this.getOrderID()));
				order = (Order) criteria.uniqueResult();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return order;
	}

	public ProductInfo getParentProductInfo() {
		if (productInfo == null) {
			try {
				Session session = DBUtil.getSessionFactory().getCurrentSession();
				Criteria criteria = session.createCriteria(ProductInfo.class);
				criteria.add(Restrictions.eq("productID", this.getProductID()));
				productInfo = (ProductInfo) criteria.uniqueResult();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return productInfo;
	}

	@Override
	public int compareTo(OrderItem orderItem) {
		if (orderItem == null) {
			return -1;
		}
		return this.orderItemID.compareTo(orderItem.orderItemID);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getName()).append(System.lineSeparator());
		builder.append("[orderItemID = ").append(orderItemID).append(",").append(System.lineSeparator());
		builder.append("orderID = ").append(orderID).append(",").append(System.lineSeparator());
		builder.append("productID = ").append(productID).append(",").append(System.lineSeparator());
		builder.append("unitPrice = ").append(unitPrice).append(",").append(System.lineSeparator());
		builder.append("quantity = ").append(quantity).append("]");
		return builder.toString();
	}

}
