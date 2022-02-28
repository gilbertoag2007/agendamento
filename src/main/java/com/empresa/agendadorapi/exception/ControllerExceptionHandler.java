package com.empresa.agendadorapi.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(RecursoNaoEncontrado.class)
  public ResponseEntity<ErrorMessage> recursoNaoEncontrado(RecursoNaoEncontrado ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(LocalDateTime.now(), ex.getMessage());
    
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
	  ErrorMessage message = new ErrorMessage(LocalDateTime.now(),ex.getMessage());
         
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }

 
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessage>> MethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
	  List<ErrorMessage> listaMensagens = new ArrayList<ErrorMessage>();
     
	  List<ObjectError> errors = ex.getBindingResult().getAllErrors();
			  for (ObjectError erro: errors) {
				  	erro.getDefaultMessage();
				  	ErrorMessage message = new ErrorMessage(LocalDateTime.now(),erro.getDefaultMessage());
				  	listaMensagens.add(message);
			  }
			  	  
    return new ResponseEntity<List<ErrorMessage>>(listaMensagens, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler(RegistroRepetido.class)
  public ResponseEntity<ErrorMessage> registroRepetido(RegistroRepetido ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(LocalDateTime.now(), ex.getMessage());
    
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
  }
}