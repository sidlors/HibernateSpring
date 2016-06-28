package mx.com.mentoringit.impl;

import static org.junit.Assert.*;

import org.hibernate.Transaction;

import mx.com.mentoringit.entities.Tipocuenta;
import mx.com.mentoringit.hibernate_test.AbstractDBTestUnit;
import mx.com.mentoringit.interfaces.ITipoCuenta;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TipoCuentaDAOTest extends AbstractDBTestUnit{
	
	

	@Ignore
	public void testCreate() {
		
		Tipocuenta tipocuenta=new Tipocuenta();
		
		try {
			tipocuenta.setNombre("PERFILES");
			assertNotNull(new TipoCuentaDAO().saveCuenta(tipocuenta));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Ignore
	public void testLoad() {
		
		Tipocuenta tipocuentaCriterio=new Tipocuenta();
		ITipoCuenta daoCuenta= new TipoCuentaDAO();
		Transaction t=AbstractDBTestUnit.getSession().getTransaction();
		t.begin();
		try {
			for (Object tipocuenta : daoCuenta.findAllCuenta(tipocuentaCriterio)) {
				System.out.println(((Tipocuenta)tipocuenta).getIdTipoCuenta()+" " +((Tipocuenta)tipocuenta).getNombre() );
			}
			assertNotNull(new TipoCuentaDAO().findAll(Tipocuenta.class));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			t.commit();
		}
		
	}
	
	
	@Ignore
	public void testFindCuenta() {
		
		Tipocuenta tipocuentaCriterio=new Tipocuenta();
		ITipoCuenta daoCuenta= new TipoCuentaDAO();
		
		try {
			
			assertNotNull(new TipoCuentaDAO().findCuentaById(Tipocuenta.class,1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Ignore
	public void testFindCuentaByName() {
		
		Tipocuenta tipocuentaCriterio=new Tipocuenta();
		ITipoCuenta daoCuenta= new TipoCuentaDAO();
		
		try {
			for (Object tipocuenta : daoCuenta.findCuentaByName(tipocuentaCriterio)) {
				System.out.println(((Tipocuenta)tipocuenta).getIdTipoCuenta()+" " +((Tipocuenta)tipocuenta).getNombre() );
			}
			assertNotNull(new TipoCuentaDAO().findCuentaByName(tipocuentaCriterio));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
