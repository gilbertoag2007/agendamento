package com.empresa.agendadorapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

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
	ProfissionalRepository profissionalTemplate;
	
	public ProfissionalDTO incluirProfissional(ProfissionalDTO dto) {
		
		Profissional prof =  mapeadorDto.profissionalDtoToProfissional(dto);
		Profissional profResult = profissionalTemplate.incluirProfissional(prof);		
		return mapeadorDto.profissionalToProfissionalDto(profResult);
	}
	
	public List<ProfissionalDTO> listarTodos(){
		
		List <Profissional> profBanco = profissionalTemplate.listarTodos();
		List<ProfissionalDTO> profissionaisDTO  = new ArrayList<ProfissionalDTO>();  
			
			for (Profissional prof: profBanco ) {
				ProfissionalDTO profDTO = mapeadorDto.profissionalToProfissionalDto(prof);
				profissionaisDTO.add(profDTO);								
			}
			return profissionaisDTO;
	}
	
	public void atualizarProfissional(ProfissionalDTO dto) {
		
		Profissional profissional = mapeadorDto.profissionalDtoToProfissional(dto);
		profissionalTemplate.atualizarProfissional(profissional);

	}
	
	public void deletarProfisisonal(String id) {
		try {
			profissionalTemplate.deletarProfissional(id);	
									
		} catch (Exception e) {
			throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, "Erro no servidor ao deletar funcionario.");
		}
				
	}
	
	public ProfissionalDTO pesquisarPorId (String id) {
		
		try { 
		Profissional prof = profissionalTemplate.pesquisarPorId(id);
		ProfissionalDTO dto;
		
		if (prof != null) {
		
			dto = mapeadorDto.profissionalToProfissionalDto(prof); 
		
		}else {
			throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Recurso não encontrado");
		}
		
		return dto;
		
		}catch (Exception e) {
			throw new ResponseStatusException (HttpStatus.BAD_REQUEST, "Erro ao salvar informações do profissional");
		
		}
		
	}
}
