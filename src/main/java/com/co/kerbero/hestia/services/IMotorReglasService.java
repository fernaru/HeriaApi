package com.co.kerbero.hestia.services;

import com.co.kerbero.hestia.entity.Rol;
import com.co.kerbero.hestia.entity.Usuario;

public interface IMotorReglasService {
	
	public void saveRule(Usuario users, Rol rol);

}
