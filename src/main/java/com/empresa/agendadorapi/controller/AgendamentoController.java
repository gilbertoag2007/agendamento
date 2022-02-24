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

import com.empresa.agendadorapi.dto.AgendamentoDTO;
import com.empresa.agendadorapi.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
	
	
	@Autowired
	AgendamentoService agendamentoService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AgendamentoDTO incluirAgendamento(@RequestBody AgendamentoDTO agendaDTO) {
		
		return agendamentoService.incluirAgendamento(agendaDTO);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AgendamentoDTO> listarTodos(){

		return agendamentoService.listarTodos();
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void atualizarAgendamento(@RequestBody AgendamentoDTO agendaDTO) {
	
		agendamentoService.atualizarAgendamento(agendaDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable String id) {
		
		agendamentoService.deletarAgendamento(id);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AgendamentoDTO pesquisarPorId(@PathVariable String id) {
		
		return agendamentoService.pesquisarPorId(id);
	}
	
	@GetMapping(value = "data/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<AgendamentoDTO> pesquisarPorData(@PathVariable String data) {
		
		return agendamentoService.pesquisarPorData(data);
	}
	
	

}
