package com.empresa.agendadorapi.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatadorDatas {

	public static String localDateTimeParaString (LocalDateTime data) {
		
		if(data != null) {
		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
			String dataFormatada = data.format(formatter);		
			return dataFormatada;
			
		}else {
			return null;
		}
	}
	
	
	
}
