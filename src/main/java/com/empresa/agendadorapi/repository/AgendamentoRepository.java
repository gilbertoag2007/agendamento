package com.empresa.agendadorapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.empresa.agendadorapi.model.Agendamento;

/**
 * 
 * Classe de conexao com o MongoDB para manter agendamento.
 *  
 * @author Gilberto Cunha
 *
 */
@Component
public class AgendamentoRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;	

	public Agendamento incluirAgendamento (Agendamento agenda) {
		Agendamento Agendamento = mongoTemplate.save(agenda);
		return Agendamento;
	}
	
	
	public List<Agendamento> listarTodos(){
		List<Agendamento> dispoBanco = mongoTemplate.findAll(Agendamento.class);
		
		return dispoBanco;
	}  
	
	public void atualizarAgendamento(Agendamento agenda) {
		mongoTemplate.save(agenda);
			
	}
	
	public void deletarAgendamento (String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.findAndRemove(query, Agendamento.class);
		
	}
	
	public Agendamento pesquisarPorId(String id) {
		Agendamento agenda = mongoTemplate.findById(id, Agendamento.class);
		return agenda;
	}
	
	public List<Agendamento> pesquisarPorData(String dataMarcacao){
		
		Query query = new Query();
		query.addCriteria(Criteria.where("data").is(dataMarcacao));
		List<Agendamento> dispoBanco = mongoTemplate.find(query, Agendamento.class);
		
		return dispoBanco;
	}  
	
}
