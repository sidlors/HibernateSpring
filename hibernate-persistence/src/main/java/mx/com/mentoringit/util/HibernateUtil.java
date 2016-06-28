package mx.com.mentoringit.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	//private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {

		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
	

	
	
	public static SessionFactory buildSessionFactory(String fileHbm) {

		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure(fileHbm)
					.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

}
