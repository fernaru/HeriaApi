package com.co.kerbero.hestia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kerbero.hestia.entity.Rol;
import com.co.kerbero.hestia.models.dao.IRolDao;

@Service
public class RolServiceImple implements IRolService {

	@Autowired
	private IRolDao rolDao;
	
	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol save(Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id, Long idUsuario) {
		// TODO Auto-generated method stub
		
	}

}
