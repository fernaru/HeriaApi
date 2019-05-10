package com.co.kerbero.hestia.entity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Reglas implements Serializable{

	private List<MenuOli> listMenus;
	
	@NotEmpty
	private Rol rol;
	
	@NotEmpty
	private Usuario users;
	
	@NotEmpty
	public String tipoPlan;
	
	
	public List<MenuOli> getListMenus() {
		return listMenus;
	}
	public void setListMenus(List<MenuOli> listMenus) {
		this.listMenus = listMenus;
	}
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
