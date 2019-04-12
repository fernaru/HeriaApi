package com.co.kerbero.hestia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="rol_menu")
public class RolMenu implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private Long idrol;
	
	@NotEmpty
	private Long idmenu;
	
	@NotEmpty
	private String estadoRol;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdrol() {
		return idrol;
	}



	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}



	public Long getIdmenu() {
		return idmenu;
	}



	public void setIdmenu(Long idmenu) {
		this.idmenu = idmenu;
	}



	public String getEstadoRol() {
		return estadoRol;
	}



	public void setEstadoRol(String estadoRol) {
		this.estadoRol = estadoRol;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
