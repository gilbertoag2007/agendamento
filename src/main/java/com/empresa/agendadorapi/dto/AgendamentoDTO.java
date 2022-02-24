package com.empresa.agendadorapi.dto;

import java.util.List;
import java.util.Objects;


public class AgendamentoDTO {

	  /* Identificador do agendamento */
	  private String id;
	  
	  /*Data dentro da agenda */
	  private String data;
	  
	  /* hora de inicial das atividades */
	  private String horaInicial;
	  
	  /* Hora final das atividades*/
	  private String horaFinal;  
	  
	  /*Indica se a data já está aberta para marcacoes */
	  private Integer aberta;
	  
	  /* Data que a agenda foi aberta para marcacoes */
	  private String dataAbertura;
	  
	  /* Data que a agenda foi fechada para marcacoes */
	  private String dataFechamento;
	    
	  /*Lista de disponibilidade dos profissionais na data*/
	  private List<DisponibilidadeDTO> disponibilidades;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public Integer getAberta() {
		return aberta;
	}

	public void setAberta(Integer aberta) {
		this.aberta = aberta;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public List<DisponibilidadeDTO> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(List<DisponibilidadeDTO> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}

	@Override
	public String toString() {
		return "AgendamentoDTO [id=" + id + ", data=" + data + ", horaInicial=" + horaInicial + ", horaFinal="
				+ horaFinal + ", aberta=" + aberta + ", dataAbertura=" + dataAbertura + ", dataFechamento="
				+ dataFechamento + ", disponibilidades=" + disponibilidades + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aberta, data, dataAbertura, dataFechamento, disponibilidades, horaFinal, horaInicial, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendamentoDTO other = (AgendamentoDTO) obj;
		return Objects.equals(aberta, other.aberta) && Objects.equals(data, other.data)
				&& Objects.equals(dataAbertura, other.dataAbertura)
				&& Objects.equals(dataFechamento, other.dataFechamento)
				&& Objects.equals(disponibilidades, other.disponibilidades)
				&& Objects.equals(horaFinal, other.horaFinal) && Objects.equals(horaInicial, other.horaInicial)
				&& Objects.equals(id, other.id);
	}
	
	
}
