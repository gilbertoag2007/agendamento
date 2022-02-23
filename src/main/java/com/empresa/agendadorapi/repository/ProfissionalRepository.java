package com.empresa.agendadorapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.empresa.agendadorapi.model.Profissional;

public interface ProfissionalRepository extends MongoRepository<Profissional, String> {

	@Query("{id:'?0'}")
	Profissional pesquisarPorID(String id);
	
	@Query("{login:'?0'}")
	Profissional pesquisarPorLogin(String login);
	
}
