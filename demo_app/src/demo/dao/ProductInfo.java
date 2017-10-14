package demo.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

public class ProductInfo implements Serializable, Comparable<ProductInfo> {
	
	private static final long serialVersionUID = 7752332622244406036L;
	private Integer productID;
	private String productName;
	private String productDescription;
	private String category;
	private Boolean productAvail;
	private BigDecimal listPrice;
	private Blob productImage;
	private String mimetype;
	private String filename;
	private Timestamp lastUpdDt;

	public ProductInfo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getProductAvail() {
		return productAvail;
	}

	public void setProductAvail(Boolean productAvail) {
		this.productAvail = productAvail;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public Blob getProductImage() {
		return productImage;
	}

	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Timestamp getLastUpdDt() {
		return lastUpdDt;
	}

	public void setLastUpdDt(Timestamp lastUpdDt) {
		this.lastUpdDt = lastUpdDt;
	}

	@Override
	public int compareTo(ProductInfo productInfo) {
		if(productInfo == null){
			return -1;
		}
		return this.productID.compareTo(productInfo.productID);
	}

}
