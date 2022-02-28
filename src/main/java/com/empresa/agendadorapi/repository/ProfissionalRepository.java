package com.empresa.agendadorapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.empresa.agendadorapi.model.Profissional;

/**
 * 
 * Classe de conexao com o MongoDB para manter profissional.
 *  
 * @author Gilberto Cunha
 *
 */

@Component
public class ProfissionalRepository {

	@Autowired
	MongoTemplate mongoTemplate;	

	public Profissional incluirProfissional (Profissional prof) {
		Profissional profissional = mongoTemplate.save(prof);
		return profissional;
	}
	
	public List<Profissional> listarTodos(){
		List<Profissional> dispoBanco = mongoTemplate.findAll(Profissional.class);
		
		return dispoBanco;
	}  
	
	public void atualizarProfissional(Profissional profissional) {
		mongoTemplate.save(profissional);
			
	}
	
	public void deletarProfissional (String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.findAndRemove(query, Profissional.class);
		
	}
	
	public Profissional pesquisarPorId(String id) {
		Profissional profissional = mongoTemplate.findById(id, Profissional.class);
		return profissional;
	}
	
	public List<Profissional> pesquisarPorCPF(String cpf) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cpf").is(cpf));
		List<Profissional> listaProf = mongoTemplate.find(query, Profissional.class);
		return listaProf;
	}
	
	public List<Profissional> pesquisarPorNome(String nome) {
		Query query = new Query();
		query.addCriteria(Criteria.where("nome").is(nome));
		List<Profissional> listaProf = mongoTemplate.find(query, Profissional.class);
		return listaProf;
	}
	
	public Long loginExiste(String login, String id) {
		Query query = new Query();
		
		if (id != null) {
			query.addCriteria(Criteria.where("login").is(login).and("id").ne(id));
		}else {
			query.addCriteria(Criteria.where("login").is(login));
		}
		
		return mongoTemplate.count(query, Profissional.class);
	}
	
	public Long cpfExiste(String cpf, String id) {
		Query query = new Query();
		
		if (id != null) {
			query.addCriteria(Criteria.where("login").is(cpf).and("id").ne(id));
		}else {
			query.addCriteria(Criteria.where("login").is(cpf));
		}
		
		return mongoTemplate.count(query, Profissional.class);
	}
	
}
