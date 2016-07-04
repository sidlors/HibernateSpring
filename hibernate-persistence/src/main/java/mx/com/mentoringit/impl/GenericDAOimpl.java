package mx.com.mentoringit.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mx.com.mentoringit.interfaces.IGenericDAO;

public class GenericDAOimpl<T> implements IGenericDAO<T> {

	protected  SessionFactory sessionFactory ;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	


	@Override
	public Integer save(T emp) throws Exception {
		Transaction transaction = sessionFactory.getCurrentSession()
				.beginTransaction();
		Integer entity = null;
		try {
			entity = (Integer) sessionFactory.getCurrentSession().save(emp);
			transaction.commit();
		} catch (Exception e) {
			e.getStackTrace();
			transaction.rollback();
			throw new Exception(e);
		}

		return entity;
	}

	@Override
	public void edit(T emp) throws Exception {

		Transaction transaction = sessionFactory.getCurrentSession()
				.beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(emp);
			transaction.commit();
		} catch (Exception e) {
			e.getStackTrace();
			transaction.rollback();
			throw new Exception(e);
		}

		
		
	}

	@Override
	public T find(Class<T> clase, int idEntity) throws Exception {
		Transaction transaction = sessionFactory.getCurrentSession()
				.beginTransaction();
		T entity = null;
		try {
			entity =  (T) sessionFactory.getCurrentSession().get(clase, idEntity);
			transaction.commit();
		} catch (Exception e) {
			e.getStackTrace();
			transaction.rollback();
			throw new Exception(e);
		}

		return entity;
	}

	@Override
	public Boolean delete(T emp) throws Exception {
		Transaction transaction = sessionFactory.getCurrentSession()
				.beginTransaction();
		Boolean entity = false;
		try {
			sessionFactory.getCurrentSession().delete(emp);
			transaction.commit();
		} catch (Exception e) {
			
			transaction.rollback();
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public List<T> findAll(Class<T> clase) throws Exception {
		
		Transaction transaction = sessionFactory.getCurrentSession()
				.beginTransaction();

		List<T> entities = null;
		try {
			entities=sessionFactory.getCurrentSession().createQuery("from " + clase.getName()).list();
			transaction.commit();
			
		} catch (Exception e) {
			e.getStackTrace();
			transaction.rollback();
			throw new Exception(e);
		}

		return entities;
	}



}
