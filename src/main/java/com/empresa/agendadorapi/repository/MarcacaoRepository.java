package com.empresa.agendadorapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.empresa.agendadorapi.model.Marcacao;

@Component
public class MarcacaoRepository {

	@Autowired
	MongoTemplate mongoTemplate;	

	public Marcacao incluirMarcacao (Marcacao marcacao) {
		Marcacao marcacaoResult = mongoTemplate.save(marcacao);
		return marcacaoResult;
	}
	
	public List<Marcacao> listarTodos(){
		List<Marcacao> marcacaoBanco = mongoTemplate.findAll(Marcacao.class);
		
		return marcacaoBanco;
	}  
	
	public void atualizarMarcacao(Marcacao marcacao) {
		mongoTemplate.save(marcacao);
			
	}
	
	public void deletarMarcacao (String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.findAndRemove(query, Marcacao.class);
		
	}
	
	public Marcacao pesquisarPorId(String id) {
		Marcacao marcacaoResult = mongoTemplate.findById(id, Marcacao.class);
		return marcacaoResult;
	}
	
	
}
