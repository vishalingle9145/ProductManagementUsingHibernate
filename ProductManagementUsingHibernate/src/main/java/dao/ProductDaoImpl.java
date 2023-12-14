package dao;

import pojos.Product;
import static utils.HibernateUtils.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDaoImpl implements ProductDao{

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
			mesg = "Product added with ID "+product.getProductId();
			
			
		}catch (RuntimeException e) {
//			error : rollback tx
			if(tx !=  null )
				tx.rollback();
//			re throw the SAME exc to the caller : to inform about the author
			throw e;
		}
		finally {
			
			if(session != null)
				session.close(); //L1 cache is destroyed,pooledout db connection returns back to the pool
			
		}
		
		return mesg;
	}

}
