package com.empresa.agendadorapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe com informacoes de um dia dentro da agenda.
 * 
 * @author Gilberto Cunha
 *
 */

@Document("agendamento")
public class Agendamento {

  @Id
  private String id;
  
  /*Data dentro da agenda */
  private LocalDate data;
  
  /* hora de inicial das atividades */
  private LocalTime horaInicial;
  
  /* Hora final das atividades*/
  private LocalTime horaFinal;  
  
  /*Indica se a data  esta aberta para marcacoes. 1=SIM  2=NAO  */
  private Integer aberta;
  
  /* Data que a agenda foi aberta para marcacoes */
  private LocalDateTime dataAbertura;
  
  /* Data que a agenda foi fechada para marcacoes */
  private LocalDateTime dataFechamento;
    
  /*Lista de disponibilidade dos profissionais na data*/
  private List<Disponibilidade> disponibilidades;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public LocalDate getData() {
	return data;
}

public void setData(LocalDate data) {
	this.data = data;
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

public Integer getAberta() {
	return aberta;
}

public void setAberta(Integer aberta) {
	this.aberta = aberta;
}

public LocalDateTime getDataAbertura() {
	return dataAbertura;
}

public void setDataAbertura(LocalDateTime dataAbertura) {
	this.dataAbertura = dataAbertura;
}

public LocalDateTime getDataFechamento() {
	return dataFechamento;
}

public void setDataFechamento(LocalDateTime dataFechamento) {
	this.dataFechamento = dataFechamento;
}

public List<Disponibilidade> getDisponibilidades() {
	return disponibilidades;
}

public void setDisponibilidades(List<Disponibilidade> disponibilidades) {
	this.disponibilidades = disponibilidades;
}

@Override
public String toString() {
	return "Agenda [id=" + id + ", data=" + data + ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal
			+ ", aberta=" + aberta + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento
			+ ", disponibilidades=" + disponibilidades + "]";
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
	Agendamento other = (Agendamento) obj;
	return Objects.equals(aberta, other.aberta) && Objects.equals(data, other.data)
			&& Objects.equals(dataAbertura, other.dataAbertura) && Objects.equals(dataFechamento, other.dataFechamento)
			&& Objects.equals(disponibilidades, other.disponibilidades) && Objects.equals(horaFinal, other.horaFinal)
			&& Objects.equals(horaInicial, other.horaInicial) && Objects.equals(id, other.id);
}


}
