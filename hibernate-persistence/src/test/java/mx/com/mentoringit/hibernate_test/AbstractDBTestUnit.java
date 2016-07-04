package mx.com.mentoringit.hibernate_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;

import mx.com.mentoringit.util.HibernateUtil;

public abstract class AbstractDBTestUnit {

	protected static Session session;

	protected static SessionFactory emf;

	@BeforeClass
	public static void setUp() {
		if (session == null) {
			System.out.println("----> Creando Entity manager");
			// EntityManagerFactory emf =
			// Persistence.createEntityManagerFactory("HSQLDBTest");
			emf = HibernateUtil.buildSessionFactory("hibernateTest.cfg.xml");
			session = emf.getCurrentSession();
			initializeData("dataset/catalog/catalog.sql");
			session.getTransaction().commit();
		}
	}

	private static void initializeData(String path) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		InputStream is = ClassLoader.getSystemResourceAsStream(path);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		Query query = null;
		try {
			line = br.readLine();
			while (line != null) {
				if (line.length() > 20 && line.indexOf("//") != 0) {
					query = session.createSQLQuery(line);
					query.executeUpdate();
					session.flush();
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			safeCloseBufferedReader(br);
		}
	}

	private static void safeCloseBufferedReader(BufferedReader br) {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				br = null;
			}
		}
	}

	@Ignore
	public  void tearDown() {
		if (session != null) {
			session.getTransaction().commit();
		}

	}

	public static Session getSession() {

		return session;
	}

	protected static SessionFactory getSessionFactory() {

		return emf;
	}

}
