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

import com.co.kerbero.hestia.entity.MenuOli;
import com.co.kerbero.hestia.services.IMenuOilService;

@CrossOrigin(origins= {"http://localhost:8088"})
@RestController
@RequestMapping("/api")
public class MenuOliRestController {
	
	@Autowired
	private IMenuOilService menuService;
	
	@GetMapping("/menu")
	public List<MenuOli> index(){
		return menuService.findAll();
	}	
	
	@PostMapping("/menu")
	public ResponseEntity<?> save(@Valid @RequestBody MenuOli menu, BindingResult result){
		
		MenuOli menuNew = new MenuOli();
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(result.hasErrors()){
			List<String> errors = result.getFieldErrors().stream().map(err -> { return "El campo '"+err.getField()+"' el mensaje "+ err.getDefaultMessage(); }).collect(Collectors.toList());
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		try {
			menuNew = menuService.save(menu);
			response.put("mensaje","El menu fue creado con exito¡");
			response.put("menu", menuNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}catch (Exception e) {
			response.put("mensaje","El menu no pudo ser creado con exito¡");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
	}
}
