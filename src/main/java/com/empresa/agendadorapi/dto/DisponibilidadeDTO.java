package com.empresa.agendadorapi.dto;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class DisponibilidadeDTO {

	@Id
	private String id;
	
	/* profissional */
	private String profissional;
	
	/* Data da disponibilidade do profissional */
	private String dataMarcacao;
	/* Hora do inicio do atendimento dentro da data */
	
	private String horaInicial;
	
	/* Horario do Limite do atendimento dentro da data */
	private String horaFinal;
		
	  /*Intervalo entre o inicio dos atendimentos */
	private Integer intervaloMinutos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}

	public String getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(String dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
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
		return "DisponibilidadeDTO [id=" + id + ", profissional=" + profissional + ", dataMarcacao=" + dataMarcacao
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
		DisponibilidadeDTO other = (DisponibilidadeDTO) obj;
		return Objects.equals(dataMarcacao, other.dataMarcacao) && Objects.equals(horaFinal, other.horaFinal)
				&& Objects.equals(horaInicial, other.horaInicial) && Objects.equals(id, other.id)
				&& Objects.equals(intervaloMinutos, other.intervaloMinutos)
				&& Objects.equals(profissional, other.profissional);
	}
	
}
