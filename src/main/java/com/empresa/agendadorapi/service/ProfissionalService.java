package com.empresa.agendadorapi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.agendadorapi.dto.ProfissionalDTO;
import com.empresa.agendadorapi.dto.mapper.MapeadorDto;
import com.empresa.agendadorapi.model.Profissional;
import com.empresa.agendadorapi.repository.ProfissionalRepository;

/**
 * Classe com os servicos relacionados a entidade Profissional
 * 
 * @author Gilberto Cunha
 *
 */

@Component
public class ProfissionalService {

	@Autowired
	MapeadorDto mapeadorDto;
	
	@Autowired
	ProfissionalRepository profissionalRepository;
	
	public ProfissionalDTO incluirProfissional(ProfissionalDTO dto) {
		
		Profissional prof =  mapeadorDto.profissionalDtoToProfissional(dto);
		prof.setDataInclusao(LocalDateTime.now());
		profissionalRepository.save(prof);
			
		return mapeadorDto.profissionalToProfissionalDto(prof);
	}
	
	public List<ProfissionalDTO> listarTodos(){
		
		List <Profissional> profBanco = profissionalRepository.findAll();
		List<ProfissionalDTO> profissionaisDTO  = new ArrayList<ProfissionalDTO>();  
		
		for (Profissional prof: profBanco ) {
			ProfissionalDTO profDTO = mapeadorDto.profissionalToProfissionalDto(prof);
			profissionaisDTO.add(profDTO);
							
		}
		return profissionaisDTO;
	}
	
	public void atualizarProfissional(ProfissionalDTO dto) {
		
		Profissional profissional = mapeadorDto.profissionalDtoToProfissional(dto);
		profissionalRepository.save(profissional);

	}
	
	public void deletarProfisisonal(String id) {
		
		profissionalRepository.deleteById(id);
	}
	
	public ProfissionalDTO pesquisarPorId (String id) {
		
		Profissional prof = profissionalRepository.pesquisarPorID(id);
		ProfissionalDTO dto = mapeadorDto.profissionalToProfissionalDto(prof); 
		
		return dto;
	}
}
