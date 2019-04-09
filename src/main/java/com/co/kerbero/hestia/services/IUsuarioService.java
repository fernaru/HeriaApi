package com.co.kerbero.hestia.services;

import java.util.List;

import com.co.kerbero.hestia.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);

}
