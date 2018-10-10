package demo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DBUtil {
	private static SessionFactory sessionFactory;

	private DBUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			ServiceRegistry builder = new StandardServiceRegistryBuilder().build();
			sessionFactory = new Configuration().configure().buildSessionFactory(builder);
		}
		return sessionFactory;
	}

}
