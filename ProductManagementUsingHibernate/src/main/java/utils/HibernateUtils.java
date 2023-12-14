package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

//	to create singleton, immutable, inherently thread safe, heavy weight
//	SessionFactory object

	private static SessionFactory factory;

	static {
		System.out.println("In static initializer block...!");
		factory = new Configuration() // empty config
				.configure() // config obj populated from hibernate.cfg.xml
				.buildSessionFactory();
	}

//	getters

	public static SessionFactory getFactory() {
		return factory;
	}

}
