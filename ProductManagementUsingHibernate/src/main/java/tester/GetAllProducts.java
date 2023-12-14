package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;

import static utils.HibernateUtils.*;

public class GetAllProducts {

	public static void main(String[] args) {
		
		
		try(SessionFactory sf = getFactory()) {
			
			ProductDaoImpl pdao = new ProductDaoImpl();
			
			System.out.println("All Products: ");
			
			pdao.getAllProducts().forEach(System.out::println);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
