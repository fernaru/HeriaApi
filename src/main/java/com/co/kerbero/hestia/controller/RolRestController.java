package com.co.kerbero.hestia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.kerbero.hestia.entity.Rol;
import com.co.kerbero.hestia.services.IRolService;

@CrossOrigin(origins= {"http://localhost:8088"})
@RestController
@RequestMapping("/api")
public class RolRestController {
	
	@Autowired
	private IRolService rolService;
	
	@GetMapping("/roles")
	public List<Rol> index(){
		return rolService.findAll();
	}

}
