package com.empresa.agendadorapi.model;

import java.time.LocalTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe com informações da marcacao de uma servico com um profissional.
 * 
 * @author Gilberto Cunha
 */
 @Document("marcacao")
public class Marcacao {

	@Id
	private String id;
	
	/* Profissional que realizara a atividade*/
	private Profissional Professional;
	
	/*Nome do usuário a ser atendido*/
	private Usuario usuario;
	
	/*Hora inicial do atendimento conforme marcacao*/
	private LocalTime horaInicialPrev;
	
	/*Hora de termino do atendimento*/
	private LocalTime HoraFinalPrev;
	
	/*Hora real de inicio do atendimento */
	private LocalTime horaInicialReal;
	
	/*Hora real de término do a atendimento*/
	private LocalTime HoraFinalReal;
	
	private String observacao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Profissional getProfessional() {
		return Professional;
	}

	public void setProfessional(Profissional professional) {
		Professional = professional;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalTime getHoraInicialPrev() {
		return horaInicialPrev;
	}

	public void setHoraInicialPrev(LocalTime horaInicialPrev) {
		this.horaInicialPrev = horaInicialPrev;
	}

	public LocalTime getHoraFinalPrev() {
		return HoraFinalPrev;
	}

	public void setHoraFinalPrev(LocalTime horaFinalPrev) {
		HoraFinalPrev = horaFinalPrev;
	}

	public LocalTime getHoraInicialReal() {
		return horaInicialReal;
	}

	public void setHoraInicialReal(LocalTime horaInicialReal) {
		this.horaInicialReal = horaInicialReal;
	}

	public LocalTime getHoraFinalReal() {
		return HoraFinalReal;
	}

	public void setHoraFinalReal(LocalTime horaFinalReal) {
		HoraFinalReal = horaFinalReal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Marcacao [id=" + id + ", Professional=" + Professional + ", usuario=" + usuario + ", horaInicialPrev="
				+ horaInicialPrev + ", HoraFinalPrev=" + HoraFinalPrev + ", horaInicialReal=" + horaInicialReal
				+ ", HoraFinalReal=" + HoraFinalReal + ", observacao=" + observacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(HoraFinalPrev, HoraFinalReal, Professional, horaInicialPrev, horaInicialReal, id,
				observacao, usuario);
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
				&& Objects.equals(Professional, other.Professional)
				&& Objects.equals(horaInicialPrev, other.horaInicialPrev)
				&& Objects.equals(horaInicialReal, other.horaInicialReal) && Objects.equals(id, other.id)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(usuario, other.usuario);
	}

	
}
