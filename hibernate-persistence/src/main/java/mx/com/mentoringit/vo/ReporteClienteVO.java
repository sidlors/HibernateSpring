package mx.com.mentoringit.vo;

import java.io.Serializable;

public class ReporteClienteVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8203691786923948831L;
	private String nombreCliente;
	private String nombreBanco;
	private int numCuenta;
	private String nombreCuenta;
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getNombreBanco() {
		return nombreBanco;
	}
	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public ReporteClienteVO(String nombreCliente, String nombreBanco, int numCuenta, String nombreCuenta) {
		super();
		this.nombreCliente = nombreCliente;
		this.nombreBanco = nombreBanco;
		this.numCuenta = numCuenta;
		this.nombreCuenta = nombreCuenta;
	}
	@Override
	public String toString() {
		return "ReporteClienteVO [nombreCliente=" + nombreCliente + ", nombreBanco=" + nombreBanco + ", numCuenta="
				+ numCuenta + ", nombreCuenta=" + nombreCuenta + "]";
	}
	
	
	
	

}
