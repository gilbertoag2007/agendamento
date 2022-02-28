package com.empresa.agendadorapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.empresa.agendadorapi.model.Usuario;

@Component
public class UsuarioRepository {

	@Autowired
	MongoTemplate mongoTemplate;	
	
	public Usuario incluirUsuario (Usuario usuario) {
		Usuario usuarioResult = mongoTemplate.save(usuario);
		return usuarioResult;
	}
	
	public List<Usuario> listarTodos(){
		List<Usuario> usuariosBanco = mongoTemplate.findAll(Usuario.class);
		
		return usuariosBanco;
	}  
	
	public void atualizarUsuario(Usuario usuario) {
		mongoTemplate.save(usuario);		
	}
	
	public void deletarUsuario (String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.findAndRemove(query, Usuario.class);
		
	}
	
	public Usuario pesquisarPorId(String id) {
		Usuario usuario = mongoTemplate.findById(id, Usuario.class);
		return usuario;
	}
		
}
