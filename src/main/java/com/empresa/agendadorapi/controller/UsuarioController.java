package com.empresa.agendadorapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.agendadorapi.dto.UsuarioDTO;
import com.empresa.agendadorapi.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDTO incluirUsuario(@RequestBody UsuarioDTO usuario) {
		return usuarioService.incluirUsuario(usuario);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> listarTodos(){
		return usuarioService.listarTodos();
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
	
		usuarioService.atualizarUsuario(usuarioDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletarUsuario(@PathVariable String id) {
		usuarioService.deletarUsuario(id);
	
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public UsuarioDTO pesquisarPorId(@PathVariable String id) {
		return usuarioService.pesquisarPorId(id);
		
	}
	
	
}
