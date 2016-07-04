package mx.com.mentoringit.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mx.com.mentoringit.entities.Cliente;
import mx.com.mentoringit.hibernate_test.AbstractDBTestUnit;


public class ClienteDAOImplTest extends AbstractDBTestUnit {

	private Cliente clienteCriterio;
	private ClienteDAOImpl servDAO;
	private List<Cliente> clientes;

	@Before
	public void tearDown() {
//		super.tearDown();
		
		clienteCriterio = new Cliente();
		servDAO = new ClienteDAOImpl();
		servDAO.setSessionFactory(emf);
		
	}

	@Test
	public void testReport() {

		

		try {

			clientes =servDAO.findCliente(Cliente.class);
			assertTrue(clientes.size() > 0);
			for (Object object : clientes) {
				Cliente cliente = (Cliente) object;
				System.out.println(cliente.getNombre() + " " + cliente.getApaterno() + " " + cliente.getAmaterno());
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// t.commit();
			System.out.println("testREort exit");
		}
	}

	@Test
	public void testfindClienteByName() {

		try {
			clientes=servDAO.findClienteByName(clienteCriterio);
			assertTrue(clientes.size() > 0);
			for (Cliente cliente :clientes ) {
				System.out.println(cliente.getNombre() + " " +  cliente.getApaterno());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
