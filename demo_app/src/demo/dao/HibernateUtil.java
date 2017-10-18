package demo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private HibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			ServiceRegistry builder = new ServiceRegistryBuilder().buildServiceRegistry();
			sessionFactory = new Configuration().configure().buildSessionFactory(builder);
		}
		return sessionFactory;
	}

}
