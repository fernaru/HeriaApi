package com.co.kerbero.hestia.services;

import java.util.List;

import com.co.kerbero.hestia.entity.MenuOli;

public interface IMenuOilService {

	public List<MenuOli> findAll();
	
	public MenuOli findById(Long id);
	
	public MenuOli save(MenuOli menu);
	
	public void delete(Long id, Long idUsuario);
	
}
