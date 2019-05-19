package com.co.kerbero.hestia.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.co.kerbero.hestia.entity.Usuario;

public interface IUsuarioDao  extends CrudRepository<Usuario, Long>  {

}
