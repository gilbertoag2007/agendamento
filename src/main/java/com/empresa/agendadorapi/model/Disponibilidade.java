package com.empresa.agendadorapi.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe com informacoes das disponibilidades dos profissionais em uma data
 *
 * @author Gilberto Cunha
 *
 */
@Document("disponibilidade")
public class Disponibilidade {

	@Id
	private String id;
	
	private Profissional profissional;
	/* Data da disponibilidade do profissional */
	
	private LocalDate dataMarcacao;
	/* Hora do inicio do atendimento dentro da data */
	
	private LocalTime horaInicial;
	
	/* Horario do Limite do atendimento dentro da data */
	private LocalTime horaFinal;
		
	  /*Intervalo entre o inicio dos atendimentos */
	private Integer intervaloMinutos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public LocalDate getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(LocalDate dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}

	public LocalTime getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(LocalTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Integer getIntervaloMinutos() {
		return intervaloMinutos;
	}

	public void setIntervaloMinutos(Integer intervaloMinutos) {
		this.intervaloMinutos = intervaloMinutos;
	}
	
	@Override
	public String toString() {
		return "Disponibilidade [id=" + id + ", profissional=" + profissional + ", dataMarcacao=" + dataMarcacao
				+ ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal + ", intervaloMinutos=" + intervaloMinutos
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataMarcacao, horaFinal, horaInicial, id, intervaloMinutos, profissional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disponibilidade other = (Disponibilidade) obj;
		return Objects.equals(dataMarcacao, other.dataMarcacao) && Objects.equals(horaFinal, other.horaFinal)
				&& Objects.equals(horaInicial, other.horaInicial) && Objects.equals(id, other.id)
				&& Objects.equals(intervaloMinutos, other.intervaloMinutos)
				&& Objects.equals(profissional, other.profissional);
	}

	
}
