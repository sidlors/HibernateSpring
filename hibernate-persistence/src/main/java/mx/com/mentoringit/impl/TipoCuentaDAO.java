package mx.com.mentoringit.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mx.com.mentoringit.entities.Tipocuenta;
import mx.com.mentoringit.interfaces.ITipoCuenta;
import mx.com.mentoringit.util.HibernateUtil;

public class TipoCuentaDAO extends GenericDAOimpl<Tipocuenta> implements ITipoCuenta {

		
	@Override
	public Integer saveCuenta(Tipocuenta tipocuenta) throws Exception {
		return save(tipocuenta);
	}

	

	@Override
	public List findAllCuenta(Tipocuenta tipocuenta) throws Exception {

		return findAll(Tipocuenta.class);
	}

	@Override
	public Boolean deleteCuenta(Tipocuenta tipocuenta) throws Exception {
		return delete(tipocuenta);
	}



	@Override
	public Tipocuenta findCuentaById(Class<Tipocuenta> tipocuenta, Integer idEntity) throws Exception {
		
	  return 	find(Tipocuenta.class,idEntity);
	}



	@Override
	public List findCuentaByName(Tipocuenta tipocuenta) throws Exception {
		Transaction t= getSessionFactory().getCurrentSession().beginTransaction();
		Criteria criteria=getSessionFactory().getCurrentSession().createCriteria(Tipocuenta.class);
		criteria.add(Restrictions.like("nombre", "P%"));
		criteria.setMaxResults(10);
		
		List lista=criteria.list();
		t.commit();
		return lista;
	}

}


