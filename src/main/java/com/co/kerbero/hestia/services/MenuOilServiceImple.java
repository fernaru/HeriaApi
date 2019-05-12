package com.co.kerbero.hestia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kerbero.hestia.entity.MenuOli;
import com.co.kerbero.hestia.models.dao.IMenuOilDao;

@Service
public class MenuOilServiceImple implements IMenuOilService {

	@Autowired
	IMenuOilDao menuDao; 
	
	@Override
	public List<MenuOli> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuOli findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuOli save(MenuOli menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id, Long idUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MenuOli> menuForTypeAdmon(Long idrol) {
		
		return null;
	}

}
