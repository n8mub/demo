package demo.dao;

import java.io.Serializable;

public class OrderItem implements Serializable, Comparable<OrderItem> {
	
	private static final long serialVersionUID = 7842518525709927090L;
	private Integer orderItemID;
	private Integer orderID;
	private Integer productID;
	private Double unitPrice;
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
		Order order = new Order();
		// TODO Auto-generated method stub
		return order;
	}
	
	public ProductInfo getParentProductInfo() {
		ProductInfo productInfo = new ProductInfo();
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
