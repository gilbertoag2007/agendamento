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

import com.empresa.agendadorapi.dto.DisponibilidadeDTO;
import com.empresa.agendadorapi.service.DisponibilidadeService;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadeController {
	
	@Autowired
	DisponibilidadeService disponibilidadeService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DisponibilidadeDTO incluirDisponibilidade( @Valid @RequestBody DisponibilidadeDTO dispoDTO) {
		
		return disponibilidadeService.incluirDisponibilidade(dispoDTO);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<DisponibilidadeDTO> listarTodos(){

		return disponibilidadeService.listarTodos();
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void atualizarDisponibilidade(@RequestBody DisponibilidadeDTO dispoDTO) {
	
		disponibilidadeService.atualizarDisponibilidade(dispoDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable String id) {
		
		disponibilidadeService.deletarDisponibilidade(id);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DisponibilidadeDTO pesquisarPorId(@PathVariable String id) {
		
		return disponibilidadeService.pesquisarPorId(id);
	}
	
	@GetMapping(value = "profissional/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<DisponibilidadeDTO> pesquisarPorProfissional(@PathVariable String id) {
		
		return disponibilidadeService.pesquisarPorProfissional(id);
	}
	
}