package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;

import static utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.Scanner;

public class GetProductByDate {
	
	public static void main(String[] args) {
		
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			
			ProductDaoImpl pdao = new ProductDaoImpl();
			
			System.out.println("Enter Date: ");
			
			pdao.getProductsByDate(LocalDate.parse(sc.next()))
			.forEach(p-> System.out.println(p.getProductId()+" "+p.getName()+" "+p.getPrice()+" "+p.getStock()));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
