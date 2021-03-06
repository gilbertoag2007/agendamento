package com.empresa.agendadorapi.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.empresa.agendadorapi.dto.ProfissionalDTO;
import com.empresa.agendadorapi.service.ProfissionalService;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {
	
	@Autowired
	ProfissionalService profissionalService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProfissionalDTO incluirProfissional( @Valid @RequestBody ProfissionalDTO profDTO) {
		return profissionalService.incluirProfissional(profDTO);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProfissionalDTO> listarTodos(){

		return profissionalService.listarTodos();
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void atualizarProfissional(@RequestBody ProfissionalDTO profDTO) {
	
		profissionalService.atualizarProfissional(profDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable String id) {
		profissionalService.deletarProfisisonal(id);
	
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public ProfissionalDTO pesquisarPorId(@PathVariable String id) {
		ProfissionalDTO dto = profissionalService.pesquisarPorId(id);
		
		return dto;
	}
		
}