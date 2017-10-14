package demo.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="DEMO_ORDER_ITEMS")
public class OrderItem implements Serializable, Comparable<OrderItem> {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name="ORDER_ITEM_ID")
	private Integer orderItemID;
	@Column(name="ORDER_ID")
	private Integer orderID;
	@JoinColumn(name="ORDER_ID",table="DEMO_ORDERS")
	private Order order;
	@Column(name="PRODUCT_ID")
	private Integer productID;
	@JoinColumn(name="PRODUCT_ID",table="DEMO_PRODUCT_INFO")
	private ProductInfo productInfo;
	@Column(name="UNIT_PRICE",precision=8,scale=2)
	private Double unitPrice;
	@Column(name="QUANTITY",precision=8)
	private Integer quantity;

	public OrderItem() {
		// TODO Auto-generated constructor stub
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
		if(order == null){
			order = new Order();
		}
		// TODO Auto-generated method stub
		return order;
	}
	
	public ProductInfo getParentProductInfo() {
		if(productInfo == null){
			productInfo = new ProductInfo();
		}
		// TODO Auto-generated method stub
		return productInfo;
	}

	@Override
	public int compareTo(OrderItem orderItem) {
		if(orderItem == null){
			return -1;
		}
		return this.orderItemID.compareTo(orderItem.orderItemID);
	}

}
