package dao;

import pojos.Product;
import pojos.ProductCategory;

import static utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addNewProduct(Product product) {

		String mesg = "Adding products failed!!!";

//		1. get Session from SessionFactory (SF)
		Session session = getFactory().openSession();

//		2. Begin a Transaction
		Transaction tx = session.beginTransaction();

//		3. try-catch - finally
		try {

			session.save(product);
//			success : commit tx
			tx.commit();
			mesg = "Product added with ID " + product.getProductId();

		} catch (RuntimeException e) {
//			error : rollback tx
			if (tx != null)
				tx.rollback();
//			re throw the SAME exc to the caller : to inform about the author
			throw e;
		} finally {

			if (session != null)
				session.close(); // L1 cache is destroyed,pooledout db connection returns back to the pool

		}

		return mesg;
	}

	@Override
	public String addNewProductCurrentSession(Product product) {

		String mesg = "Product adding failed...!";

		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			session.save(product);

			tx.commit();

			mesg = "Product added with ID " + product.getProductId();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();

			throw e;

		}

		return mesg;
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = null;

		String jpql = "select p from Product p";

		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			products = session.createQuery(jpql, Product.class).getResultList();

			tx.commit();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();

			throw e;
		}

		return products;
	}

	@Override
	public List<Product> getProductsByCategory(ProductCategory category) {

		List<Product> products = null;

		String jpql = "select p from Product p  where p.category=:type";

		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			products = session.createQuery(jpql, Product.class).setParameter("type", category).getResultList();

			tx.commit();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}

		return products;
	}

	@Override
	public List<Product> getProductsByDate(LocalDate date) {

		List<Product> products = null;

		String jpql = "select new pojos.Product(productId, name, price, stock) from Product p where p.manufactureDate > : date";

		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			products = session.createQuery(jpql, Product.class).setParameter("date", date).getResultList();

			tx.commit();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}

		return products;
	}

	@Override
	public String updateProductPrice(Integer productId, double priceOffset) {

//		String jpql = "update Product p set p.price=:price where p.productId=:id";

		Product product = null;

		String mesg = "Not Updated....!";

		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			product = session.get(Product.class, productId);

			if (product != null) {
				product.setPrice(product.getPrice() + priceOffset);

				mesg = "Updation successfully...!";
			}

			tx.commit();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}

//		product.setPrice(product.getPrice()+ priceOffset);

		return mesg;
	}

}
