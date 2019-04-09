package com.co.kerbero.hestia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="rol")
public class Rol implements Serializable {

	@Id
	private Long id;
	
	@NotEmpty
	@Column(nullable = false)
	private Long rol;
	
	@NotEmpty
	@Column(nullable = false)
	private String descripcion;
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getRol() {
		return rol;
	}



	public void setRol(Long rol) {
		this.rol = rol;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
