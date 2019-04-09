package com.co.kerbero.hestia.services;

import java.util.List;

import com.co.kerbero.hestia.entity.Rol;

public interface IRolService {
	
	public List<Rol> findAll();
	
	public Rol findById(Long id);
	
	public Rol save(Rol rol);
	
	public void delete(Long id, Long idUsuario);

}
