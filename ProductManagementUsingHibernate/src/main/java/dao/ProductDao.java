package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Product;
import pojos.ProductCategory;

public interface ProductDao {

//	add method to insert new product details
	
	public String addNewProduct(Product product);
	
	String addNewProductCurrentSession(Product product);
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(ProductCategory category);
	
	List<Product> getProductsByDate(LocalDate date);
	
	String updateProductPrice(Integer productId, double price);
	
}
