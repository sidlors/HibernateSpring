package mx.com.mentoringit.interfaces;

import java.util.List;

import mx.com.mentoringit.entities.Tipocuenta;

public interface ITipoCuenta {
	
	public Integer saveCuenta(Tipocuenta tipocuenta) throws Exception;
	
	public Tipocuenta findCuentaById(Class<Tipocuenta> tipocuenta,Integer idEntity) throws Exception;
	
	public List<Tipocuenta> findCuentaByName(Tipocuenta tipocuenta) throws Exception;
	
	public List<Tipocuenta> findAllCuenta(Tipocuenta tipocuenta) throws Exception;
	
	public Boolean deleteCuenta(Tipocuenta tipocuenta) throws Exception;

}
