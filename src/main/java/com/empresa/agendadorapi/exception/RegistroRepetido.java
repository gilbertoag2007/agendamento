package com.empresa.agendadorapi.exception;

public class RegistroRepetido extends RuntimeException{
	 
	private static final long serialVersionUID = 1L;

	  public RegistroRepetido(String msg) {
	    super(msg);
	  }
}
