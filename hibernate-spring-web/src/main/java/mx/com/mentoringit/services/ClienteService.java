package mx.com.mentoringit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mentoringit.entities.Cliente;
import mx.com.mentoringit.interfaces.ICliente;

@Service("clienteService")
public class ClienteService {

		@Autowired
		private ICliente clienteDAO;
		
		@Transactional
		public List<Cliente> obtenerClientes() throws Exception{
			
			List<Cliente> clientes = clienteDAO.obtenerClientes(Cliente.class);
			return clientes;
		}
}
