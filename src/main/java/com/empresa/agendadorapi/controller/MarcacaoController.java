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

import com.empresa.agendadorapi.dto.MarcacaoDTO;
import com.empresa.agendadorapi.service.MarcacaoService;

@RestController
@RequestMapping("/marcacoes")
public class MarcacaoController {

	@Autowired
	MarcacaoService marcacaoService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MarcacaoDTO incluirMarcacao(@RequestBody MarcacaoDTO marcacaoDTO) {
		
		return marcacaoService.incluirMarcacao(marcacaoDTO);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MarcacaoDTO> listarTodos(){

		return marcacaoService.listarTodos();
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void atualizarMarcacao(@RequestBody MarcacaoDTO marcacaoDTO) {
	
		marcacaoService.atualizarMarcacao(marcacaoDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable String id) {
		
		marcacaoService.deletarMarcacao(id);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MarcacaoDTO pesquisarPorId(@PathVariable String id) {
		
		return marcacaoService.pesquisarPorId(id);
	}
	
	
	
	
	
	
}
