package mx.com.mentoringit.interfaces;

import java.util.List;

import mx.com.mentoringit.entities.Cliente;
import mx.com.mentoringit.vo.ReporteClienteVO;

public interface ICliente {
	
	public Integer saveCliente(Cliente Cliente) throws Exception;
	
	public Cliente findClienteById(Class<Cliente> Cliente,Integer idEntity) throws Exception;
	
	public List<ReporteClienteVO> obtenerReporteClientes( ) throws Exception;
	
	public List findClienteByName(Cliente Cliente) throws Exception;
	
	public List findCliente(Class<Cliente> clazz) throws Exception;
	
	public Boolean deleteCliente(Cliente Cliente) throws Exception;

	public List<Cliente> obtenerClientes(Class<Cliente> clazz) throws Exception;

}
