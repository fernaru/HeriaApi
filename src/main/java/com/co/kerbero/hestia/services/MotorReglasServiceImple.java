package com.co.kerbero.hestia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kerbero.hestia.entity.MenuOli;
import com.co.kerbero.hestia.entity.Reglas;
import com.co.kerbero.hestia.entity.Rol;
import com.co.kerbero.hestia.entity.RolMenu;
import com.co.kerbero.hestia.entity.Usuario;
import com.co.kerbero.hestia.entity.UsuarioRol;
import com.co.kerbero.hestia.models.dao.IMenuOilDao;
import com.co.kerbero.hestia.models.dao.IRolDao;
import com.co.kerbero.hestia.models.dao.IRolMenu;
import com.co.kerbero.hestia.models.dao.IUsuarioDao;
import com.co.kerbero.hestia.models.dao.IUsuarioRolDao;

@Service
public class MotorReglasServiceImple implements IMotorReglasService {

	@Autowired
	private  IMenuOilDao menuDao;
	
	@Autowired
	private  IUsuarioDao usuarioDao;
	
	@Autowired
	private  IRolDao rolDao;
	
	@Autowired
	private  IUsuarioRolDao usuRolDao;
	
	@Autowired
	private  IRolMenu menRolDao;
	
	@Override
	public void saveRule( Reglas reglas) {
		List<MenuOli> listMenu = new ArrayList<MenuOli>();
		List<MenuOli> menuFree = new ArrayList<MenuOli>();
		List<MenuOli> menuclasico = new ArrayList<MenuOli>();
		List<MenuOli> menuMedium = new ArrayList<MenuOli>();
		List<MenuOli> menuVip = new ArrayList<MenuOli>();
		
		if (reglas.getRol().getRol() != null) {
			listMenu = asigPermissingAdmon(reglas.getRol().getRol());
		}
		
		listMenu.forEach( men -> {
			if(men.getTypeUsuario()==1) {
				menuFree.add(men);
			}else if(men.getTypeUsuario() == 101){
				menuclasico.add(men);
			}else if(men.getTypeUsuario() == 102) {
				menuMedium.add(men);
			}else{
				menuVip.add(men);
			}
		});
		if(!menuFree.isEmpty()) {
			Usuario newUsers =usuarioDao.save(reglas.getUsers());
			Rol newRol = rolDao.save(reglas.getRol());
			UsuarioRol usuRol = new UsuarioRol();
			usuRol.setIdRol((Long)newRol.getId());
			usuRol.setIdUsuario(newUsers.getNumIdenti());
			usuRolDao.save(usuRol);
			menuFree.forEach(free -> {
				RolMenu rolMen = new RolMenu();
				rolMen.setIdmenu(free.getId());
				rolMen.setIdrol(newRol.getId());
				rolMen.setEstadoRol("Activo");
				menRolDao.save(rolMen);
				
			});	
		}else if(!menuclasico.isEmpty()) {
			Usuario newUsers =usuarioDao.save(reglas.getUsers());
			Rol newRol = rolDao.save(reglas.getRol());
			UsuarioRol usuRol = new UsuarioRol();
			usuRol.setIdRol(newRol.getId());
			usuRol.setIdUsuario(newUsers.getNumIdenti());
			usuRolDao.save(usuRol);
			menuclasico.forEach(free -> {
				RolMenu rolMen = new RolMenu();
				rolMen.setIdmenu(free.getId());
				rolMen.setIdrol(newRol.getId());
				rolMen.setEstadoRol("Activo");
				menRolDao.save(rolMen);
			});
		}else if(!menuMedium.isEmpty()) {
			Usuario newUsers =usuarioDao.save(reglas.getUsers());
			Rol newRol = rolDao.save(reglas.getRol());
			UsuarioRol usuRol = new UsuarioRol();
			usuRol.setIdRol(newRol.getId());
			usuRol.setIdUsuario(newUsers.getNumIdenti());
			usuRolDao.save(usuRol);
			menuMedium.forEach(free -> {
				RolMenu rolMen = new RolMenu();
				rolMen.setIdmenu(free.getId());
				rolMen.setIdrol(newRol.getId());
				rolMen.setEstadoRol("Activo");
				menRolDao.save(rolMen);
			});
		}else {
			Usuario newUsers =usuarioDao.save(reglas.getUsers());
			Rol newRol = rolDao.save(reglas.getRol());
			UsuarioRol usuRol = new UsuarioRol();
			usuRol.setIdRol(newRol.getId());
			usuRol.setIdUsuario(newUsers.getNumIdenti());
			usuRolDao.save(usuRol);
			menuVip.forEach(free -> {
				RolMenu rolMen = new RolMenu();
				rolMen.setIdmenu(free.getId());
				rolMen.setIdrol(newRol.getId());
				rolMen.setEstadoRol("Activo");
				menRolDao.save(rolMen);
			});
		}
		
	}

	// 100 = admon free.
	private List<MenuOli> asigPermissingAdmon(Long idRol) {
		List<MenuOli> menus = (List<MenuOli>)menuDao.findAll();		
		return menus;
	}

}
