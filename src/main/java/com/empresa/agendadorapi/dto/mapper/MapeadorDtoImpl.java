package com.empresa.agendadorapi.dto.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.processing.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.agendadorapi.dto.DisponibilidadeDTO;
import com.empresa.agendadorapi.dto.ProfissionalDTO;
import com.empresa.agendadorapi.model.Disponibilidade;
import com.empresa.agendadorapi.model.Profissional;
import com.empresa.agendadorapi.repository.ProfissionalRepository;

/*
 * Classe responsavel por converter DTO em entidade e vice versa
 * */
@Generated(value = "org.mapstruct.ap.MappingProcessor")
@Component
public class MapeadorDtoImpl implements MapeadorDto {

	@Autowired
	ProfissionalRepository profissionalRepository;
	
	@Override
	public Profissional profissionalDtoToProfissional(ProfissionalDTO dto) {
		
		Profissional profissional = new Profissional();
		profissional.setId(dto.getId());
		profissional.setNome(dto.getNome());
		profissional.setCpf(dto.getCpf());
		profissional.setFuncao(dto.getFuncao());
		profissional.setLogin(dto.getLogin());
		profissional.setSenha(dto.getSenha());
		
		if (dto.getDataInclusao() == null || dto.getDataInclusao().isEmpty()) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime agora = LocalDateTime.now();
			agora.format(formatter);
			
			profissional.setDataInclusao(agora);
		
		}else {
			profissional.setDataInclusao(LocalDateTime.parse(dto.getDataInclusao()));
			
		}
			
		return profissional;
	}

	@Override
	public ProfissionalDTO profissionalToProfissionalDto(Profissional prof) {
	
		ProfissionalDTO dto = new ProfissionalDTO();
		dto.setId(prof.getId());
		dto.setNome(prof.getNome());
		dto.setCpf(prof.getCpf());
		dto.setFuncao(prof.getFuncao());
		dto.setLogin(prof.getLogin());
		dto.setSenha(prof.getSenha());
		dto.setDataInclusao(String.valueOf(prof.getDataInclusao()));
		dto.setDataExclusao(String.valueOf(prof.getDataExclusao()));
		
		return dto;
	}

	@Override
	public Disponibilidade disponibilidadeDtoToDisponibilidade(DisponibilidadeDTO dto) {
		Disponibilidade dispo = new Disponibilidade();
		dispo.setId(dto.getId());
		
		DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(dto.getDataMarcacao(), FOMATTER);
				 
				System.out.println(localDate);
				//Get formatted String
				String dateString = FOMATTER.format(localDate);
				 
				System.out.println(dateString);   //07/15/2018
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate marcacao = LocalDate.parse(dto.getDataMarcacao(), formatter);
		marcacao.format(formatter);
		dispo.setDataMarcacao(marcacao);
		
		dispo.setIntervaloMinutos(dto.getIntervaloMinutos());
		dispo.setProfissional(profissionalRepository.pesquisarPorID(dto.getProfissional()));
		
		if (dto.getHoraInicial() == null || dto.getHoraInicial().isEmpty()) {
			dispo.setHoraInicial(LocalTime.now());
		
		}else {
			dispo.setHoraInicial(LocalTime.parse(dto.getHoraInicial()));
		}
		
		if (dto.getHoraFinal() == null || dto.getHoraFinal().isEmpty()) {
			dispo.setHoraFinal(LocalTime.now());
		
		}else {
			dispo.setHoraFinal(LocalTime.parse(dto.getHoraFinal()));
			
		}
			
		return dispo;
	}

	@Override
	public DisponibilidadeDTO disponibilidadeToDisponibilidadeDto(Disponibilidade disponibilidade) {
		
		DisponibilidadeDTO dto = new DisponibilidadeDTO();
		dto.setId(disponibilidade.getId());
		dto.setDataMarcacao(disponibilidade.getDataMarcacao().toString());
		dto.setHoraInicial(String.valueOf(disponibilidade.getHoraInicial()));
		dto.setHoraFinal(String.valueOf(disponibilidade.getHoraFinal()));
		dto.setIntervaloMinutos(disponibilidade.getIntervaloMinutos());
		
		if (disponibilidade.getProfissional() != null) {
			dto.setProfissional(disponibilidade.getProfissional().getId());
		}
		
		
		return dto;
	}
	
	
}
