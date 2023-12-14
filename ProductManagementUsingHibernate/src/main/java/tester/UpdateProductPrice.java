package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;

public class UpdateProductPrice {

	public static void main(String[] args) {

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {

			ProductDaoImpl pdao = new ProductDaoImpl();

			System.out.println("Enter ID and Price: ");
			
			pdao.updateProductPrice(sc.nextInt(), sc.nextDouble());

		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
