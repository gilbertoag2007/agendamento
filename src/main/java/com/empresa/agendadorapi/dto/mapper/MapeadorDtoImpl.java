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
		dispo.setFuncao(dto.getFuncao());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dispo.setDataDisponibilidade(LocalDate.parse(dto.getDataDisponibilidade(), formatter));
		
		dispo.setIntervaloMinutos(dto.getIntervaloMinutos());
		dispo.setProfissional(profissionalRepository.pesquisarPorID(dto.getIdProfissional()));
		
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
		dto.setFuncao(disponibilidade.getFuncao());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = formatter.format(disponibilidade.getDataDisponibilidade());
		
		dto.setDataDisponibilidade(dataFormatada);
		dto.setHoraInicial(String.valueOf(disponibilidade.getHoraInicial()));
		dto.setHoraFinal(String.valueOf(disponibilidade.getHoraFinal()));
		dto.setIntervaloMinutos(disponibilidade.getIntervaloMinutos());
		
		if (disponibilidade.getProfissional() != null) {
			dto.setIdProfissional(disponibilidade.getProfissional().getId());
			dto.setNomeProfissional(disponibilidade.getProfissional().getNome());
		}
		
		return dto;
	}
	
	
}
