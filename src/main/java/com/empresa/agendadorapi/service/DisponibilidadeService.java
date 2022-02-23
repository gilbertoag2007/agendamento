package com.empresa.agendadorapi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.empresa.agendadorapi.dto.DisponibilidadeDTO;
import com.empresa.agendadorapi.dto.mapper.MapeadorDto;
import com.empresa.agendadorapi.model.Disponibilidade;
import com.empresa.agendadorapi.repository.DisponibilidadeRepository;

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
	DisponibilidadeRepository disponibilidadeRepository;
	
	
		
	public DisponibilidadeDTO incluirDisponibilidade(DisponibilidadeDTO dto) {
			
		Disponibilidade dispo =  mapeadorDto.disponibilidadeDtoToDisponibilidade(dto);
		disponibilidadeRepository.save(dispo);
		return mapeadorDto.disponibilidadeToDisponibilidadeDto(dispo);
	}
		
	
	public List<DisponibilidadeDTO> listarTodos(){
			
		List <Disponibilidade> dispoBanco = disponibilidadeRepository.findAll();
		List<DisponibilidadeDTO> disponibilidadesDTO  = new ArrayList<DisponibilidadeDTO>();  
			
			for (Disponibilidade dispo: dispoBanco ) {
				DisponibilidadeDTO dispoDTO = mapeadorDto.disponibilidadeToDisponibilidadeDto(dispo);
				disponibilidadesDTO.add(dispoDTO);
								
			}
			return disponibilidadesDTO;
	}
		
	public void atualizarDisponibilidade(DisponibilidadeDTO dto) {
			
		Disponibilidade disponibilidade = mapeadorDto.disponibilidadeDtoToDisponibilidade(dto);
		disponibilidadeRepository.save(disponibilidade);

	}
		
	public void deletarDisponibilidade(String id) {
		disponibilidadeRepository.deleteById(id);
	}
		
	public DisponibilidadeDTO pesquisarPorId (String id) {
			
		Disponibilidade dispo = disponibilidadeRepository.pesquisarPorID(id);
		DisponibilidadeDTO dto = mapeadorDto.disponibilidadeToDisponibilidadeDto(dispo); 
		
		return dto;
	}
	
}
