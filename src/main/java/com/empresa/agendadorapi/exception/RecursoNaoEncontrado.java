package com.empresa.agendadorapi.exception;


public class RecursoNaoEncontrado extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public RecursoNaoEncontrado(String msg) {
    super(msg);
  }
}
