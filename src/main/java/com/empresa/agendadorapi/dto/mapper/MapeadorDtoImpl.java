package com.empresa.agendadorapi.dto.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.agendadorapi.dto.AgendamentoDTO;
import com.empresa.agendadorapi.dto.DisponibilidadeDTO;
import com.empresa.agendadorapi.dto.MarcacaoDTO;
import com.empresa.agendadorapi.dto.ProfissionalDTO;
import com.empresa.agendadorapi.dto.UsuarioDTO;
import com.empresa.agendadorapi.model.Agendamento;
import com.empresa.agendadorapi.model.Disponibilidade;
import com.empresa.agendadorapi.model.Marcacao;
import com.empresa.agendadorapi.model.Profissional;
import com.empresa.agendadorapi.model.Usuario;
import com.empresa.agendadorapi.repository.DisponibilidadeRepository;
import com.empresa.agendadorapi.repository.ProfissionalRepository;
import com.empresa.agendadorapi.repository.UsuarioRepository;
import com.empresa.agendadorapi.utils.FormatadorDatas;

/*
 * Classe responsavel por converter DTO em entidade e vice versa
 * */
@Generated(value = "org.mapstruct.ap.MappingProcessor")
@Component
public class MapeadorDtoImpl implements MapeadorDto {

	@Autowired
	ProfissionalRepository profissionalRepository;
	
	@Autowired
	DisponibilidadeRepository disponibilidadeRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@Override
	public Profissional profissionalDtoToProfissional(ProfissionalDTO dto) {
		
		Profissional profissional = new Profissional();
		profissional.setId(dto.getId());
		profissional.setNome(dto.getNome());
		profissional.setCpf(dto.getCpf());
		profissional.setLogin(dto.getLogin());
		profissional.setSenha(dto.getSenha());
		profissional.setDataInclusao(LocalDateTime.now());
		
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
		dto.setDataInclusao(FormatadorDatas.localDateTimeParaString(prof.getDataInclusao()));
		dto.setDataExclusao(FormatadorDatas.localDateTimeParaString(prof.getDataExclusao()));
		
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
		dispo.setProfissional(profissionalRepository.pesquisarPorId(dto.getIdProfissional()));
		
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

	@Override
	public Agendamento agendamentoDtoToAgendamento(AgendamentoDTO agendaDto) {
		Agendamento agenda = new Agendamento();
		agenda.setId(agendaDto.getId());
		
		
		if(agendaDto.getData() != null) {
			DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			agenda.setData(LocalDate.parse(agendaDto.getData(),formatData));	
			
		}
		
		DateTimeFormatter formatDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		if(agendaDto.getDataAbertura() != null) {
			agenda.setDataAbertura(LocalDateTime.parse(agendaDto.getDataAbertura(), formatDataHora));
			
		}
		
		if(agendaDto.getDataFechamento() != null ) {
			if (!agendaDto.getDataFechamento().isEmpty()) {
				agenda.setDataFechamento(LocalDateTime.parse(agendaDto.getDataFechamento(), formatDataHora));
			}
		}
	
		agenda.setAberta(agendaDto.getAberta());
		
		if(agendaDto.getHoraInicial() != null) {
			agenda.setHoraInicial(LocalTime.parse(agendaDto.getHoraInicial()));
		}
		
		if(agendaDto.getHoraFinal() != null) {
			agenda.setHoraFinal(null);
		}
		
		if(agendaDto.getDisponibilidades() != null) {
			List<Disponibilidade> disponibilidades = new ArrayList<Disponibilidade>();
			
					for (DisponibilidadeDTO dispDTO: agendaDto.getDisponibilidades()) {
						Disponibilidade dispo = disponibilidadeRepository.pesquisarPorId(dispDTO.getId());
						disponibilidades.add(dispo);
					}
		agenda.setDisponibilidades(disponibilidades);
		}
		
		return agenda;
	}

	@Override
	public AgendamentoDTO agendamentoToAgendamentoDto(Agendamento agendamento) {
	
		AgendamentoDTO dto = new AgendamentoDTO();
		dto.setId(agendamento.getId());
		
		DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		if(agendamento.getData() != null) {
			dto.setData(formatData.format(agendamento.getData()));
		}
		if(agendamento.getDataAbertura() != null) {
			dto.setDataAbertura(formatDataHora.format(agendamento.getDataAbertura()));
		
		}
		if(agendamento.getDataFechamento() != null){
			dto.setDataFechamento(formatDataHora.format(agendamento.getDataFechamento()));
			
		}
		
		dto.setAberta(agendamento.getAberta());
		dto.setHoraInicial(String.valueOf(agendamento.getHoraInicial()));
		dto.setHoraFinal(String.valueOf(agendamento.getHoraFinal()));
		
		if(agendamento.getDisponibilidades() != null) {
			List<DisponibilidadeDTO> dispoDTOs = new ArrayList<DisponibilidadeDTO>();
			
			for (Disponibilidade dispo: agendamento.getDisponibilidades()) {
				
				DisponibilidadeDTO dispoDto = disponibilidadeToDisponibilidadeDto(dispo);
				dispoDTOs.add(dispoDto);
			}
			
			dto.setDisponibilidades(dispoDTOs);
		}
		
		
		return dto;
	}

	@Override
	public Usuario usuarioDtoToUsuario(UsuarioDTO dto) {
			
		Usuario usuario = new Usuario();
		usuario.setId(dto.getId());
		usuario.setNome(dto.getNome());
		usuario.setIdade(Integer.valueOf(dto.getIdade()));
		usuario.setCpf(dto.getCpf());
		usuario.setResponsavel(dto.getResponsavel());
		usuario.setEmail(dto.getEmail());
		usuario.setTelefone(dto.getTelefone());
		usuario.setObservacao(dto.getObservacao());
		
		return usuario;
	}

	@Override
	public UsuarioDTO usuarioToUsuarioDto(Usuario usuario) {
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setIdade(usuario.getIdade());
		dto.setCpf(usuario.getCpf());
		dto.setResponsavel(usuario.getResponsavel());
		dto.setEmail(usuario.getEmail());
		dto.setTelefone(usuario.getTelefone());
		dto.setObservacao(usuario.getObservacao());
		
		return dto;
	}

	@Override
	public Marcacao marcacaoDtoToMarcacao(MarcacaoDTO dto) {
		
		Marcacao marcacao = new Marcacao();
		marcacao.setId(dto.getId());
		
		if(dto.getUsuario() != null) {
			Usuario usuario  = usuarioRepository.pesquisarPorId(dto.getUsuario().getId());
			marcacao.setUsuario(usuario);
		}
		
		if(dto.getProfessional() != null) {
			Profissional profissional =  profissionalRepository.pesquisarPorId(dto.getProfessional().getId());
			marcacao.setProfessional(profissional);
	
		}
		
		if(dto.getHoraInicialPrev() != null) {
			marcacao.setHoraInicialPrev(LocalTime.parse(dto.getHoraInicialPrev()));
		}
		
		if (dto.getHoraFinalPrev() != null) {
			marcacao.setHoraFinalPrev(LocalTime.parse(dto.getHoraFinalPrev()));
		}
		
		if(dto.getHoraInicialReal() != null) {
			marcacao.setHoraInicialReal(LocalTime.parse(dto.getHoraInicialReal()));
		
		}
		if (dto.getHoraFinalReal() != null) {
			marcacao.setHoraFinalReal(LocalTime.parse(dto.getHoraFinalReal()));
		}
		
		marcacao.setObservacao(dto.getObservacao());
		
		return marcacao;
	}

	@Override
	public MarcacaoDTO marcacaoToMarcacaoDto(Marcacao marcacao) {
		
		MarcacaoDTO dto = new MarcacaoDTO();
		dto.setId(marcacao.getId());
		
		if (marcacao.getUsuario() != null) {
			
			UsuarioDTO usuarioDTO = usuarioToUsuarioDto(marcacao.getUsuario());
			dto.setUsuario(usuarioDTO);
		}
		
		if (marcacao.getProfessional() != null) {
			
			ProfissionalDTO profissionalDTO = profissionalToProfissionalDto(marcacao.getProfessional());
			dto.setProfessional(profissionalDTO);
		}
		
		dto.setHoraInicialPrev(String.valueOf(marcacao.getHoraInicialPrev()));
		dto.setHoraFinalPrev(String.valueOf(marcacao.getHoraFinalPrev()));
		dto.setHoraInicialReal(String.valueOf(marcacao.getHoraFinalPrev()));
		dto.setHoraFinalReal(String.valueOf(marcacao.getHoraFinalReal()));
		dto.setObservacao(marcacao.getObservacao());
		
		return dto;
	}


	
}
