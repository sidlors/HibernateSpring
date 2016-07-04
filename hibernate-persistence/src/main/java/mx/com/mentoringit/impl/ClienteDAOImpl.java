package mx.com.mentoringit.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.mentoringit.entities.Cliente;
import mx.com.mentoringit.interfaces.ICliente;
import mx.com.mentoringit.vo.ReporteClienteVO;

@Repository("clienteDAO")
public class ClienteDAOImpl extends GenericDAOimpl<Cliente> implements ICliente {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer saveCliente(Cliente cliente) throws Exception {		
		return save(cliente);
	}

	@Override
	public Cliente findClienteById(Class<Cliente> cliente, Integer idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findClienteByName(Cliente cliente) throws Exception {
		
		
		Transaction t =getSessionFactory().getCurrentSession().beginTransaction();
		
		Criteria criteria =getSessionFactory().getCurrentSession().createCriteria(Cliente.class);
		criteria.add(Restrictions.like("nombre", "M%"))
		.createCriteria("cuentas", JoinType.INNER_JOIN)
		.createCriteria("tipocuenta", JoinType.INNER_JOIN.INNER_JOIN)
		.add(Restrictions.like("nombre", "P%"));
		List<Cliente> lista= criteria.list();
		t.commit();
		return lista;
	}

	@Override
	public List findCliente(Class<Cliente> clazz) throws Exception {
		return findAll(clazz);
	}

	@Override
	public Boolean deleteCliente(Cliente cliente) throws Exception {
		return delete(cliente);
	}

	@Override
	public List<ReporteClienteVO> obtenerReporteClientes( ) throws Exception {
//		String hqlQuery="select New mx.com.mentoringit.vo.ReporteClienteVO("
//				+" cte.nombre, "
//				+" bco.nombre, "
//				+" ctas.numeroCuenta,"
//				+" tctas.nombre )"
//				+" from Cliente as cte "
//				+" inner join cte.banco as bco "
//				+" inner join cte.cuentas as ctas "
//				+" inner join ctas.tipocuenta as tctas";
//		Query query=getSessionFactory().getCurrentSession().createQuery(hqlQuery);
//		Query query=getSessionFactory().getCurrentSession().createNamedQuery("reporte.cliente");
		Query query=getSessionFactory().getCurrentSession().getNamedQuery("reporte.cliente.param").setParameter("param", "P%");
		List<ReporteClienteVO> listaReporteCliente=query.list();
		for (ReporteClienteVO reporteClienteVO : listaReporteCliente) {
			System.out.println(reporteClienteVO);
		}
		return listaReporteCliente;
	}
	
	
	@Override
	public List<Cliente> obtenerClientes(Class<Cliente> clazz) throws Exception {

		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Cliente.class);
		criteria.add(Restrictions.like("nombre", "M%"))
				.createCriteria("cuentas", JoinType.INNER_JOIN)
				.createCriteria("tipocuenta", JoinType.INNER_JOIN)
				.add(Restrictions.like("nombre", "I%"));


		List<Cliente> lista = criteria.list();

		for (Cliente cliente : lista) {
			System.out.println(cliente.getNombre() + " "
					+ cliente.getBanco().getNombre() + " "
					+ cliente.getCuentas().iterator().next().getNumeroCuenta());
		}
		return lista;
	}
	

	protected void setSessionFactory(SessionFactory sessionFactory) {
		super.sessionFactory= sessionFactory;
		this.sessionFactory=sessionFactory;
	}

}
