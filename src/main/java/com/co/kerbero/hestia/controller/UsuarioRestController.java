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

import com.co.kerbero.hestia.entity.Usuario;
import com.co.kerbero.hestia.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:8088"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public List<Usuario> index(){
		return usuarioService.findAll();		
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result){
		Usuario usuarioNew = new Usuario();
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()){
			List<String> errors = result.getFieldErrors().stream().map(err -> { return "El campo '"+err.getField()+"' el mensaje "+ err.getDefaultMessage(); }).collect(Collectors.toList());
			response.put("Errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		try {
			usuarioNew = usuarioService.save(usuario);
			response.put("mensaje","El usuario fue creado con exito!.");
			response.put("usuario", usuarioNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.put("mensaje","El usuario puedo ser creado!.");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
