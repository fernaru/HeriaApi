package com.co.kerbero.hestia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.kerbero.hestia.entity.Reglas;
import com.co.kerbero.hestia.services.IMotorReglasService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/motor")
public class MotorReglasController {
	
	@Autowired
	private IMotorReglasService motor;
	
	@PostMapping("/reglas")
	public ResponseEntity<?> create(@Valid @RequestBody Reglas reglas, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> { return "El campo '"+err.getField()+"' el mensaje "+ err.getDefaultMessage();}).collect(Collectors.toList());
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			motor.saveRule(reglas.getUsers(), reglas.getRol());
			response.put("mensaje", "El usuario ha sido creado con éxito");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al creacion");
			response.put("error", e.getMessage().concat(". ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
