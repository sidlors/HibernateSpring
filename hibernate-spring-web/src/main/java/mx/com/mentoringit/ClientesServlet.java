package mx.com.mentoringit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import mx.com.mentoringit.entities.Cliente;
import mx.com.mentoringit.services.ClienteService;

/**
 * Servlet implementation class ClientesServlet
 */
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ClienteService clienteService=(ClienteService)context.getBean("clienteService");
		PrintWriter out=response.getWriter();
		try {
			List<Cliente> clientes= clienteService.obtenerClientes();
			for (Cliente cliente : clientes) {
				System.out.println(cliente.getNombre());
				System.out.println(cliente.getApaterno());
				out.println(cliente.getNombre() + " ");
				out.println(cliente.getApaterno() + "<br/>");
			}
		} catch (Exception e) {
			out.println(e.getMessage());
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
