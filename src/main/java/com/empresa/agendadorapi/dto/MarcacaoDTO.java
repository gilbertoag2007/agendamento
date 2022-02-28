package com.empresa.agendadorapi.dto;

import java.util.Objects;

public class MarcacaoDTO {

	private String id;
	
	/* Profissional que realizara a atividade*/
	private ProfissionalDTO Professional;
	
	/*Nome do usuário a ser atendido*/
	private UsuarioDTO usuario;
	
	/*Hora inicial do atendimento conforme marcacao*/
	private String horaInicialPrev;
	
	/*Hora de termino do atendimento*/
	private String HoraFinalPrev;
	
	/*Hora real de inicio do atendimento */
	private String horaInicialReal;
	
	/*Hora real de término do a atendimento*/
	private String HoraFinalReal;
	
	
	private String observacao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProfissionalDTO getProfessional() {
		return Professional;
	}

	public void setProfessional(ProfissionalDTO professional) {
		Professional = professional;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "MarcacaoDTO [id=" + id + ", Professional=" + Professional + ", usuario=" + usuario
				+ ", horaInicialPrev=" + horaInicialPrev + ", HoraFinalPrev=" + HoraFinalPrev + ", horaInicialReal="
				+ horaInicialReal + ", HoraFinalReal=" + HoraFinalReal + ", observacao=" + observacao + "]";
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
		MarcacaoDTO other = (MarcacaoDTO) obj;
		return Objects.equals(HoraFinalPrev, other.HoraFinalPrev) && Objects.equals(HoraFinalReal, other.HoraFinalReal)
				&& Objects.equals(Professional, other.Professional)
				&& Objects.equals(horaInicialPrev, other.horaInicialPrev)
				&& Objects.equals(horaInicialReal, other.horaInicialReal) && Objects.equals(id, other.id)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(usuario, other.usuario);
	}

	

}
