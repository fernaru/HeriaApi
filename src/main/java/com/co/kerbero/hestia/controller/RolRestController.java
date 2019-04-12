package com.co.kerbero.hestia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/rol")
	public ResponseEntity<?> save(@Valid @RequestBody Rol rol, BindingResult result){
		
		Rol rolNew = new Rol();
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(result.hasErrors()){
			List<String> errors = result.getFieldErrors().stream().map(err -> { return "El campo '"+err.getField()+"' el mensaje "+ err.getDefaultMessage(); }).collect(Collectors.toList());
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		try {
			rolNew = rolService.save(rol);
			response.put("mensaje","El rol fue creado con exito¡");
			response.put("menu", rolNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}catch (Exception e) {
			response.put("mensaje","El rol no pudo ser creado con exito¡");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
	}
}
