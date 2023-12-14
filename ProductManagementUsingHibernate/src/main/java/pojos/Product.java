package pojos;

import java.time.LocalDate;

import javax.persistence.*;

// product table : id, name, category, price, stock, description, manu_date

@Entity // class level run time annotation to tell hibernate, following class is an
		// entity to ...

@Table(name = "products")
public class Product {

	@Id // constraint PK

//	to specify automatic generation of PKs : def strategy : AUTO
//	replaced by IDENTITY => auto increment constraint
//	will be added on the column (Best suitab le for Mysql DB)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;

	@Column(length = 100, nullable = false)
	private String name; // not null constraint

//	by def col type : int --> to storeenum ordinal, to replace it by 
	@Enumerated(EnumType.STRING) // varchar
	@Column(length = 20)
	private ProductCategory category;

	private double price;
	private int stock;

	@Column(name = "product_desc", length = 200)
	private String productDesc;

	@Column(name = "manufacture_date")
	private LocalDate manufactureDate;

	public Product() {

	}

	public Product(String name, ProductCategory category, double price, int stock, String productDesc,
			LocalDate manufactureDate) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.productDesc = productDesc;
		this.manufactureDate = manufactureDate;
	}

//	getters and setters
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + ", productDesc=" + productDesc + ", manufactureDate=" + manufactureDate + "]";
	}

}
