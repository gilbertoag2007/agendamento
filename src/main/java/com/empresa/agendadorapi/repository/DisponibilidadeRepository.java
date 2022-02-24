package com.empresa.agendadorapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.empresa.agendadorapi.model.Disponibilidade;
import com.empresa.agendadorapi.model.Profissional;

/**
 * 
 * Classe de conexao com o MongoDB para manter disponibilidade.
 *  
 * @author Gilberto Cunha
 *
 */

@Component
public class DisponibilidadeRepository {

	@Autowired
	MongoTemplate mongoTemplate;	

	public Disponibilidade incluirDisponibilidade (Disponibilidade dispo) {
		Disponibilidade disponibilidade = mongoTemplate.save(dispo);
		return disponibilidade;
	}
	
	public List<Disponibilidade> pesquisarPorProfissinal(Profissional profissional){
		
		Query query = new Query();
		query.addCriteria(Criteria.where("profissional").is(profissional));
		List<Disponibilidade> dispoBanco = mongoTemplate.find(query, Disponibilidade.class);
		
		return dispoBanco;
	}  
	
	public List<Disponibilidade> listarTodos(){
		List<Disponibilidade> dispoBanco = mongoTemplate.findAll(Disponibilidade.class);
		
		return dispoBanco;
	}  
	
	public void atualizarDisponibilidade(Disponibilidade dispo) {
		mongoTemplate.save(dispo);
			
	}
	
	public void deletarDisponibilidade (String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.findAndRemove(query, Disponibilidade.class);
		
	}
	
	public Disponibilidade pesquisarPorId(String id) {
		Disponibilidade dispo = mongoTemplate.findById(id, Disponibilidade.class);
		return dispo;
	}
	
}
