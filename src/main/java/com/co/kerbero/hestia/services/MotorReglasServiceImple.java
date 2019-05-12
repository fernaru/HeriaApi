package com.co.kerbero.hestia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kerbero.hestia.entity.MenuOli;
import com.co.kerbero.hestia.entity.Rol;
import com.co.kerbero.hestia.entity.Usuario;

@Service
public class MotorReglasServiceImple implements IMotorReglasService {

	@Autowired
	IMenuOilService menuService;

	@Override
	public void saveRule(Usuario users, Rol rol) {
		List<MenuOli> listMenu = new ArrayList<MenuOli>();
		if (rol.getRol() == 100) {
			listMenu = asigPermissingAdmon(rol.getRol());
		} else if (rol.getRol() == 101) {
			listMenu = asigPermissingAdmon(rol.getRol());
		} else if (rol.getRol() == 102) {
			listMenu = asigPermissingAdmon(rol.getRol());
		} else if (rol.getRol() == 101) {
			listMenu = asigPermissingAdmon(rol.getRol());
		}
	}

	// 100 = admon free.
	private List<MenuOli> asigPermissingAdmon(Long idRol) {
		List<MenuOli> menus = menuService.menuForTypeAdmon(idRol);
		// consultar los menus y ver cuales son los que estan permitidos para el tipo de
		// usuario administrador.
		return menus;
	}

}
