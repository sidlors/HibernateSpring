package mx.com.mentoringit.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateUtilTest {


	@Test
	public void testGetSessionFactory() {
		assertNotNull(HibernateUtil.buildSessionFactory());
	}

}
