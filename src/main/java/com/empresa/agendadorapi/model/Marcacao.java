package com.empresa.agendadorapi.model;

import java.util.Objects;

/**
 * Classe com informações da marcacao de uma servico com um profissional.
 * 
 * @author Gilberto Cunha
 */
 
public class Marcacao {

	private Long id;
	/* Nome da atividade a ser realizada*/
	private String atividade;
	
	/* Profissional que realizara a atividade*/
	private String Professional;
	
	/*Nome do usuário a ser atendido*/
	private String usuario;
	
	/*Hora inicial do atendimento conforme marcacao*/
	private String horaInicialPrev;
	
	/*Hora de termino do atendimento*/
	private String HoraFinalPrev;
	
	/*Hora real de inicio do atendimento */
	private String horaInicialReal;
	
	/*Hora real de término do a atendimento*/
	private String HoraFinalReal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String getProfessional() {
		return Professional;
	}

	public void setProfessional(String professional) {
		Professional = professional;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getHoraInicialPrev() {
		return horaInicialPrev;
	}

	public void setHoraInicialPrev(String horaInicialPrev) {
		this.horaInicialPrev = horaInicialPrev;
	}

	public String getHoraFinalPrev() {
		return HoraFinalPrev;
	}

	public void setHoraFinalPrev(String horaFinalPrev) {
		HoraFinalPrev = horaFinalPrev;
	}

	public String getHoraInicialReal() {
		return horaInicialReal;
	}

	public void setHoraInicialReal(String horaInicialReal) {
		this.horaInicialReal = horaInicialReal;
	}

	public String getHoraFinalReal() {
		return HoraFinalReal;
	}

	public void setHoraFinalReal(String horaFinalReal) {
		HoraFinalReal = horaFinalReal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(HoraFinalPrev, HoraFinalReal, Professional, atividade, horaInicialPrev, horaInicialReal, id,
				usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marcacao other = (Marcacao) obj;
		return Objects.equals(HoraFinalPrev, other.HoraFinalPrev) && Objects.equals(HoraFinalReal, other.HoraFinalReal)
				&& Objects.equals(Professional, other.Professional) && Objects.equals(atividade, other.atividade)
				&& Objects.equals(horaInicialPrev, other.horaInicialPrev)
				&& Objects.equals(horaInicialReal, other.horaInicialReal) && Objects.equals(id, other.id)
				&& Objects.equals(usuario, other.usuario);
	}
	
	
}
