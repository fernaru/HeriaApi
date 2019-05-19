package com.co.kerbero.hestia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario_rol")
public class UsuarioRol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long idUsuario;
	
	@NotNull
	private Long idRol;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}



	public Long getIdRol() {
		return idRol;
	}



	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
