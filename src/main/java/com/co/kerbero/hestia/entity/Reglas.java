package com.co.kerbero.hestia.entity;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class Reglas implements Serializable{
	
	
	private Rol rol;
	
	private Usuario users;
	
	@NotEmpty
	public String tipoPlan;
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Usuario getUsers() {
		return users;
	}
	public void setUsers(Usuario users) {
		this.users = users;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
