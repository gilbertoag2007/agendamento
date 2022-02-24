package com.empresa.agendadorapi.dto.mapper;

import org.mapstruct.Mapper;

import com.empresa.agendadorapi.dto.AgendamentoDTO;
import com.empresa.agendadorapi.dto.DisponibilidadeDTO;
import com.empresa.agendadorapi.dto.ProfissionalDTO;
import com.empresa.agendadorapi.model.Agendamento;
import com.empresa.agendadorapi.model.Disponibilidade;
import com.empresa.agendadorapi.model.Profissional;

@Mapper(componentModel = "spring")
public interface MapeadorDto {

	public Profissional profissionalDtoToProfissional (ProfissionalDTO dto);
	
	public ProfissionalDTO profissionalToProfissionalDto(Profissional profissional);
	
	public Disponibilidade disponibilidadeDtoToDisponibilidade(DisponibilidadeDTO dto);
	
	public DisponibilidadeDTO disponibilidadeToDisponibilidadeDto(Disponibilidade disponibilidade);

	public Agendamento agendamentoDtoToAgendamento (AgendamentoDTO dto);
	
	public AgendamentoDTO agendamentoToAgendamentoDto (Agendamento agendamento);
}
