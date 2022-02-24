package com.empresa.agendadorapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.agendadorapi.dto.AgendamentoDTO;
import com.empresa.agendadorapi.dto.mapper.MapeadorDto;
import com.empresa.agendadorapi.model.Agendamento;
import com.empresa.agendadorapi.repository.AgendamentoRepository;
import com.empresa.agendadorapi.repository.ProfissionalRepository;

@Service
public class AgendamentoService {

	@Autowired
	MapeadorDto mapeadorDto;
	
	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	@Autowired
	ProfissionalRepository profissionalRepository;
		
	public AgendamentoDTO incluirAgendamento(AgendamentoDTO dto) {
		Agendamento agendaResult = agendamentoRepository.incluirAgendamento(mapeadorDto.agendamentoDtoToAgendamento(dto));		
		
		return mapeadorDto.agendamentoToAgendamentoDto(agendaResult);
	}
		
	
	public List<AgendamentoDTO> listarTodos(){
			
		List <Agendamento> agendaBanco = agendamentoRepository.listarTodos();
		List<AgendamentoDTO> agendamentosDTO  = new ArrayList<AgendamentoDTO>();  
			
			for (Agendamento agenda: agendaBanco ) {
				AgendamentoDTO agendaDTO = mapeadorDto.agendamentoToAgendamentoDto(agenda);
				agendamentosDTO.add(agendaDTO);
								
			}
			return agendamentosDTO;
	}
		
	public void atualizarAgendamento(AgendamentoDTO dto) {
		Agendamento agendamento = mapeadorDto.agendamentoDtoToAgendamento(dto);
		agendamentoRepository.atualizarAgendamento(agendamento);
	}
		
	public void deletarAgendamento(String id) {
		agendamentoRepository.deletarAgendamento(id);
	}
		
	public AgendamentoDTO pesquisarPorId (String id) {
			
		Agendamento dispo = agendamentoRepository.pesquisarPorId(id);
		AgendamentoDTO dto = mapeadorDto.agendamentoToAgendamentoDto(dispo); 
		
		return dto;
	}
	
	public List<AgendamentoDTO> pesquisarPorData(String data) {
		
		
		List<Agendamento> agendaBanco = agendamentoRepository.pesquisarPorData(data);
		List<AgendamentoDTO> AgendamentosDTO  = new ArrayList<AgendamentoDTO>();  
		
		for (Agendamento agenda: agendaBanco ) {
			AgendamentoDTO agendaDTO = mapeadorDto.agendamentoToAgendamentoDto(agenda);
			AgendamentosDTO.add(agendaDTO);						
		}
		
		return AgendamentosDTO;
	}
	
	
}
