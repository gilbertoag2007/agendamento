package com.empresa.agendadorapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.agendadorapi.dto.DisponibilidadeDTO;
import com.empresa.agendadorapi.dto.mapper.MapeadorDto;
import com.empresa.agendadorapi.model.Disponibilidade;
import com.empresa.agendadorapi.model.Profissional;
import com.empresa.agendadorapi.repository.DisponibilidadeRepository;
import com.empresa.agendadorapi.repository.ProfissionalRepository;

/**
 * 
 * Classe com os servicos relacionados a entidade Disponibilidade
 *  
 * @author Gilberto Cunha
 *
 */
@Service
public class DisponibilidadeService {

	@Autowired
	MapeadorDto mapeadorDto;
	
	@Autowired
	DisponibilidadeRepository disponibilidadeTemplate;
	
	@Autowired
	ProfissionalRepository profissionalRepository;
		
	public DisponibilidadeDTO incluirDisponibilidade(DisponibilidadeDTO dto) {
			
		Disponibilidade dispo =  mapeadorDto.disponibilidadeDtoToDisponibilidade(dto);
		Disponibilidade dispo2 = disponibilidadeTemplate.incluirDisponibilidade(dispo);		
		return mapeadorDto.disponibilidadeToDisponibilidadeDto(dispo2);
	}
		
	
	public List<DisponibilidadeDTO> listarTodos(){
			
		List <Disponibilidade> dispoBanco = disponibilidadeTemplate.listarTodos();
		List<DisponibilidadeDTO> disponibilidadesDTO  = new ArrayList<DisponibilidadeDTO>();  
			
			for (Disponibilidade dispo: dispoBanco ) {
				DisponibilidadeDTO dispoDTO = mapeadorDto.disponibilidadeToDisponibilidadeDto(dispo);
				disponibilidadesDTO.add(dispoDTO);
								
			}
			return disponibilidadesDTO;
	}
		
	public void atualizarDisponibilidade(DisponibilidadeDTO dto) {
		Disponibilidade disponibilidade = mapeadorDto.disponibilidadeDtoToDisponibilidade(dto);
		disponibilidadeTemplate.atualizarDisponibilidade(disponibilidade);
	}
		
	public void deletarDisponibilidade(String id) {
		disponibilidadeTemplate.deletarDisponibilidade(id);
	}
		
	public DisponibilidadeDTO pesquisarPorId (String id) {
			
		Disponibilidade dispo = disponibilidadeTemplate.pesquisarPorId(id);
		DisponibilidadeDTO dto = mapeadorDto.disponibilidadeToDisponibilidadeDto(dispo); 
		
		return dto;
	}
	
	public List<DisponibilidadeDTO> pesquisarPorProfissional(String id) {
		
		Profissional prof = profissionalRepository.pesquisarPorId(id);
		
		
		List<Disponibilidade> dispoBanco = disponibilidadeTemplate.pesquisarPorProfissinal(prof);
		List<DisponibilidadeDTO> disponibilidadesDTO  = new ArrayList<DisponibilidadeDTO>();  
		
		for (Disponibilidade dispo: dispoBanco ) {
			DisponibilidadeDTO dispoDTO = mapeadorDto.disponibilidadeToDisponibilidadeDto(dispo);
			disponibilidadesDTO.add(dispoDTO);						
		}
		
		return disponibilidadesDTO;
	}
	
}
