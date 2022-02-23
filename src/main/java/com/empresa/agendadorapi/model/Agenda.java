package com.empresa.agendadorapi.model;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * Classe com informacoes de um dia dentro da agenda.
 * 
 * @author Gilberto Cunha
 *
 */
public class Agenda {


  private Long id;
  
  /*Data dentro da agenda */
  private Calendar data;
  
  /* hora de inicial das atividades */
  private String horaInicial;
  
  /* Hora final das atividades*/
  private String horaFinal;  
  
  /*Indica se a data já está aberta para marcacoes */
  private Character aberta;
  
  /* Data que a agenda foi aberta para marcacoes */
  private Calendar dataAbertura;
  
  /* Data que a agenda foi fechada para marcacoes */
  private Calendar dataFechamento;
  
  
  /*Lista de disponibilidade dos profissionais na data*/
  private List<Disponibilidade> disponibilidades;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public Calendar getData() {
	return data;
}


public void setData(Calendar data) {
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


public Character getAberta() {
	return aberta;
}


public void setAberta(Character aberta) {
	this.aberta = aberta;
}


public Calendar getDataAbertura() {
	return dataAbertura;
}


public void setDataAbertura(Calendar dataAbertura) {
	this.dataAbertura = dataAbertura;
}


public Calendar getDataFechamento() {
	return dataFechamento;
}


public void setDataFechamento(Calendar dataFechamento) {
	this.dataFechamento = dataFechamento;
}


public List<Disponibilidade> getDisponibilidades() {
	return disponibilidades;
}


public void setDisponibilidades(List<Disponibilidade> disponibilidades) {
	this.disponibilidades = disponibilidades;
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
	Agenda other = (Agenda) obj;
	return Objects.equals(aberta, other.aberta) && Objects.equals(data, other.data)
			&& Objects.equals(dataAbertura, other.dataAbertura) && Objects.equals(dataFechamento, other.dataFechamento)
			&& Objects.equals(disponibilidades, other.disponibilidades) && Objects.equals(horaFinal, other.horaFinal)
			&& Objects.equals(horaInicial, other.horaInicial) && Objects.equals(id, other.id);
}



}
