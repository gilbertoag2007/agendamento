package com.empresa.agendadorapi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.empresa.agendadorapi.dto.ProfissionalDTO;
import com.empresa.agendadorapi.dto.mapper.MapeadorDto;
import com.empresa.agendadorapi.exception.RecursoNaoEncontrado;
import com.empresa.agendadorapi.exception.RegistroRepetido;
import com.empresa.agendadorapi.model.Disponibilidade;
import com.empresa.agendadorapi.model.Profissional;
import com.empresa.agendadorapi.repository.DisponibilidadeRepository;
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
	
	@Autowired
	DisponibilidadeRepository disponibilidadeRepository;
	
	public ProfissionalDTO incluirProfissional(@Valid ProfissionalDTO dto) {
			
		
		Boolean loginRepetido = loginExiste(dto);
		
		if (loginRepetido) {
			throw new RegistroRepetido("Ja existe um usuário com login informado.");
		}
		
		Boolean cpfRepetido = cpfExiste(dto);
		
		if (cpfRepetido) {
			throw new RegistroRepetido("Ja usuário com cpf informado.");
		}
				
		Profissional prof =  mapeadorDto.profissionalDtoToProfissional(dto);
		Profissional profResult = profissionalRepository.incluirProfissional(prof);		
		return mapeadorDto.profissionalToProfissionalDto(profResult);
	
	}
	
	public List<ProfissionalDTO> listarTodos(){
		
		List <Profissional> profBanco = profissionalRepository.listarTodos();
		List<ProfissionalDTO> profissionaisDTO  = new ArrayList<ProfissionalDTO>();  
			
			for (Profissional prof: profBanco ) {
				ProfissionalDTO profDTO = mapeadorDto.profissionalToProfissionalDto(prof);
				profissionaisDTO.add(profDTO);								
			}
			return profissionaisDTO;
	}
	
	public void atualizarProfissional(ProfissionalDTO dto) {
		
		Boolean loginRepetido = loginExiste(dto);
		
		if (loginRepetido) {
			throw new RegistroRepetido("Ja existe um usuário com login informado.");
		}
		
		Boolean cpfRepetido = cpfExiste(dto);
		
		if (cpfRepetido) {
			throw new RegistroRepetido("Ja usuário com cpf informado.");
		}	
			
			Profissional prof = profissionalRepository.pesquisarPorId(dto.getId());
			
			if(prof != null) {
			
				Profissional profissional = mapeadorDto.profissionalDtoToProfissional(dto);
				profissionalRepository.atualizarProfissional(profissional);		
				
			}else {
				
				throw new RecursoNaoEncontrado("Profissional nao encontrado");	
			}
			
	}
	
	public void deletarProfisisonal(String id) {
		try {
			
			Profissional prof = profissionalRepository.pesquisarPorId(id);
			
			if (prof != null) {
				
				List<Disponibilidade> diponibilidadesBanco = disponibilidadeRepository.pesquisarPorProfissinal(prof);
				
					if (diponibilidadesBanco.size() > 0) {
						inativarProfissional(id);	
					
					}else {
						
						profissionalRepository.deletarProfissional(id);
					}					
			
			}else {
				
				throw new RecursoNaoEncontrado("Profissional nao encontrado");	
			}
		} catch (Exception e) {
			throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno ao deletar funcionario.");
		}
				
	}
	
	public ProfissionalDTO pesquisarPorId (String id) {
		
	
		Profissional prof = profissionalRepository.pesquisarPorId(id);
		ProfissionalDTO dto;
		
		if (prof != null) {
		
			dto = mapeadorDto.profissionalToProfissionalDto(prof); 
		}else {
			throw new RecursoNaoEncontrado("Profissional não encontrado");	
		
		}
			return dto;
		
		}
	
	public void inativarProfissional(String id) {
		
		Profissional prof = profissionalRepository.pesquisarPorId(id);
		
		if (prof != null) {	
			
			prof.setDataExclusao(LocalDateTime.now());
			profissionalRepository.atualizarProfissional(prof);
		
		}else {
			
			throw new RecursoNaoEncontrado("Profissional não encontrado");	
			
		}
	}
	
	/* verifica se existe um usuario cadastrado com login informado  true = existe false = nao existe*/
	private Boolean loginExiste(ProfissionalDTO dto) {
			
		Long resultado = profissionalRepository.loginExiste(dto.getLogin(), dto.getId());
		
		if (resultado > 1) {
			return true;
		}else {
			return false;	
		}
	} 
	
	/* verifica se existe um usuario cadastrado com cpf informado  true = existe false = nao existe */
	private Boolean cpfExiste(ProfissionalDTO dto) {
		
		Long resultado = profissionalRepository.cpfExiste(dto.getCpf(), dto.getId());
		
		if (resultado > 1) {
			return true;
		}else {
			return false;	
		}
	} 
	
}
