package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import pojos.Product;
import pojos.ProductCategory;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;


public class AddProduct {
	
	public static void main(String[] args) {
		
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in) ) {
			

			System.out.println("Enter details: productName, productCategory, price, stock, productDesc, manufactureDate");
			Product p = new Product(sc.next(), ProductCategory.valueOf(sc.next().toUpperCase()), sc.nextDouble(), sc.nextInt(), sc.next(), LocalDate.parse(sc.next()));
			
			ProductDaoImpl pdao = new ProductDaoImpl();
			
			System.out.println(pdao.addNewProduct(p));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
