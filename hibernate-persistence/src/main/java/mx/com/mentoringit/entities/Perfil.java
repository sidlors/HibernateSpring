package mx.com.mentoringit.entities;
// Generated 20-jun-2016 21:40:30 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil implements java.io.Serializable {

	private Integer idPerfil;
	private String nombre;
	private Set<Login> logins = new HashSet<Login>(0);

	public Perfil() {
	}

	public Perfil(String nombre) {
		this.nombre = nombre;
	}

	public Perfil(String nombre, Set<Login> logins) {
		this.nombre = nombre;
		this.logins = logins;
	}

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(Set<Login> logins) {
		this.logins = logins;
	}

}
