package com.empresa.agendadorapi.dto.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Teste {

	public static void main(String[] args) {
		
		//Create formatter
		DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 
		//Local date instance
		LocalDate localDate = LocalDate.parse("20/02/2022", FOMATTER);
		 
		System.out.println(localDate);
		String dateString = FOMATTER.format(localDate);
		 
		System.out.println(dateString);   //07/15/2018

	}

}
