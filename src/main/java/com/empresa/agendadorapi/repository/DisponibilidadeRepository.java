package com.empresa.agendadorapi.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.empresa.agendadorapi.model.Disponibilidade;
import com.empresa.agendadorapi.model.Profissional;

public interface DisponibilidadeRepository extends MongoRepository<Disponibilidade, String> {

	@Query("{id:'?0'}")
	Disponibilidade pesquisarPorID(String id);
	
	@Query("{dataMarcacao:'?0'}")
	List<Disponibilidade> pesquisarPorData(String data);
	
	@Query("{profissional:'?0'}")
	List<Disponibilidade> pesquisarPorProfissional(Profissional profissional);
}
