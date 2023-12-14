package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import pojos.Product;
import pojos.ProductCategory;

import static utils.HibernateUtils.*;

import java.util.List;
import java.util.Scanner;

public class GetProductByCategory {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			
			ProductDaoImpl pdao = new ProductDaoImpl();
			
			System.out.println("Enter category(BOOK, MAGAZINE, SHOES, CLOTHING): ");
			
			pdao.getProductsByCategory(ProductCategory.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
