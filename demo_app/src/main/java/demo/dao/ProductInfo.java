package demo.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEMO_PRODUCT_INFO")
public class ProductInfo implements Serializable, Comparable<ProductInfo> {
	
	public static final String PRODUCT_ID = "PRODUCT_ID";
	public static final String PRODUCT_NAME = "PRODUCT_NAME";
	public static final String PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";
	public static final String CATEGORY = "CATEGORY";
	public static final String PRODUCT_AVAIL = "PRODUCT_AVAIL";
	public static final String LIST_PRICE = "LIST_PRICE";
	public static final String PRODUCT_IMAGE = "PRODUCT_IMAGE";
	public static final String MIMETYPE = "MIMETYPE";
	public static final String FILENAME = "FILENAME";
	public static final String IMAGE_LAST_UPDATE = "IMAGE_LAST_UPDATE";
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name="PRODUCT_ID")
	private Integer productID;
	@Column(name="PRODUCT_NAME",length=50)
	private String productName;
	@Column(name="PRODUCT_DESCRIPTION",length=2000)
	private String productDescription;
	@Column(name="CATEGORY",length=30)
	private String category;
	@Column(name="PRODUCT_AVAIL")
	private Boolean productAvail;
	@Column(name="LIST_PRICE",precision=8,scale=2)
	private BigDecimal listPrice;
	@Column(name="PRODUCT_IMAGE")
	private Blob productImage;
	@Column(name="MIMETYPE",length=255)
	private String mimetype;
	@Column(name="FILENAME",length=400)
	private String filename;
	@Column(name="IMAGE_LAST_UPDATE")
	private Timestamp lastUpdDt;

	public ProductInfo() {
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getName()).append(System.lineSeparator());
		builder.append("[productID = ").append(productID).append(",").append(System.lineSeparator());
		builder.append("productName = ").append(productName).append(",").append(System.lineSeparator());
		builder.append("productDescription = ").append(productDescription).append(",").append(System.lineSeparator());
		builder.append("category = ").append(category).append(",").append(System.lineSeparator());
		builder.append("productAvail = ").append(productAvail).append(",").append(System.lineSeparator());
		builder.append("listPrice = ").append(listPrice).append(",").append(System.lineSeparator());
		builder.append("mimetype = ").append(mimetype).append(",").append(System.lineSeparator());
		builder.append("filename = ").append(filename).append(",").append(System.lineSeparator());
		builder.append("lastUpdDt = ").append(lastUpdDt).append("]");
		return builder.toString();
	}

}
