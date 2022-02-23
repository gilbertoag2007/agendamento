package com.empresa.agendadorapi.dto;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class DisponibilidadeDTO {

	@Id
	private String id;
	
	/* id do profissional */
	private String idProfissional;
	
	/* nome do profissional */
	private String nomeProfissional;
	
	/* funcao do profissional na qual ele estara disponivel*/
	private String funcao;
	
	/* Data da disponibilidade do profissional */
	private String dataDisponibilidade;
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

	public String getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(String idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getDataDisponibilidade() {
		return dataDisponibilidade;
	}

	public void setDataDisponibilidade(String dataDisponibilidade) {
		this.dataDisponibilidade = dataDisponibilidade;
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
		return "DisponibilidadeDTO [id=" + id + ", idProfissional=" + idProfissional + ", nomeProfissional="
				+ nomeProfissional + ", funcao=" + funcao + ", dataDisponibilidade=" + dataDisponibilidade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDisponibilidade, funcao, horaFinal, horaInicial, id, idProfissional, intervaloMinutos,
				nomeProfissional);
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
		return Objects.equals(dataDisponibilidade, other.dataDisponibilidade) && Objects.equals(funcao, other.funcao)
				&& Objects.equals(horaFinal, other.horaFinal) && Objects.equals(horaInicial, other.horaInicial)
				&& Objects.equals(id, other.id) && Objects.equals(idProfissional, other.idProfissional)
				&& Objects.equals(intervaloMinutos, other.intervaloMinutos)
				&& Objects.equals(nomeProfissional, other.nomeProfissional);
	}

	
}
