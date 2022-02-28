package com.empresa.agendadorapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.agendadorapi.dto.MarcacaoDTO;
import com.empresa.agendadorapi.dto.mapper.MapeadorDto;
import com.empresa.agendadorapi.model.Marcacao;
import com.empresa.agendadorapi.repository.MarcacaoRepository;

@Service
public class MarcacaoService {

	@Autowired
	MapeadorDto mapeadorDto;
	
	@Autowired
	MarcacaoRepository marcacaoTemplate;
	

		
	public MarcacaoDTO incluirMarcacao(MarcacaoDTO dto) {
		Marcacao marcacao =  mapeadorDto.marcacaoDtoToMarcacao(dto);
		Marcacao marcacaoResult = marcacaoTemplate.incluirMarcacao(marcacao);		
		return mapeadorDto.marcacaoToMarcacaoDto(marcacaoResult);
	}
		
	
	public List<MarcacaoDTO> listarTodos(){
			
		List <Marcacao> marcacaoBanco = marcacaoTemplate.listarTodos();
		List<MarcacaoDTO> marcacoesDTO  = new ArrayList<MarcacaoDTO>();  
			
			for (Marcacao marcacao: marcacaoBanco ) {
				MarcacaoDTO marcacaoDTO = mapeadorDto.marcacaoToMarcacaoDto(marcacao);
				marcacoesDTO.add(marcacaoDTO);
								
			}
			return marcacoesDTO;
	}
		
	public void atualizarMarcacao(MarcacaoDTO dto) {
		Marcacao marcacao = mapeadorDto.marcacaoDtoToMarcacao(dto);
		marcacaoTemplate.atualizarMarcacao(marcacao);
	}
		
	public void deletarMarcacao(String id) {
		marcacaoTemplate.deletarMarcacao(id);
	}
		
	public MarcacaoDTO pesquisarPorId (String id) {
			
		Marcacao marcacao = marcacaoTemplate.pesquisarPorId(id);
		MarcacaoDTO dto = mapeadorDto.marcacaoToMarcacaoDto(marcacao); 
		
		return dto;
	}
		
	
}
