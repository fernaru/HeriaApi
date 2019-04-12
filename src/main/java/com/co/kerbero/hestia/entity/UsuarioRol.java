package com.co.kerbero.hestia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="usuario_rol")
public class UsuarioRol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private Long idUsuario;
	
	@NotEmpty
	private Long idRol;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
