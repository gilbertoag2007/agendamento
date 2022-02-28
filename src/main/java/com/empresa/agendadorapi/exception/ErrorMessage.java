package com.empresa.agendadorapi.exception;

import java.time.LocalDateTime;
/**
 * Classe com informações do erro ocorrido
 *
 * @author Gilberto Cunha
 */
public class ErrorMessage {
 // Data do erro;
  private LocalDateTime dateErro;
  
  //Lista de mensagens de erro
  private String mensagem;

  public ErrorMessage( LocalDateTime date, String messagem) {
	  this.dateErro = date;
	  this.mensagem = messagem;
  }

public LocalDateTime getDateErro() {
	return dateErro;
}

public void setDateErro(LocalDateTime dateErro) {
	this.dateErro = dateErro;
}

public String getMensagem() {
	return mensagem;
}

public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
}

}
