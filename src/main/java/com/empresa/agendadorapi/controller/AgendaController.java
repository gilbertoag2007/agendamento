package com.empresa.agendadorapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.agendadorapi.repository.ProfissionalRepository;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	ProfissionalRepository profissionalRepository;
		
	@GetMapping("profissional")
	public String profissional() {
	
		
	
		
		System.out.println("GEROU LOG?");
		/*
		try {
		
			
			profissionalRepository.deleteAll();
			
			System.out.println("INICIO GRAVACAO MONGODB USUARIO 1");
			Profissional prof1 = new Profissional();
			prof1.setNome("Gilberto da Silva Cunha");
			prof1.setCpf("12345678922");
			prof1.setDataInclusao("19/02/2022");
			prof1.setFuncao("Analista");
			prof1.setLogin("gilberto");
			prof1.setSenha("123456");
			profissionalRepository.save(prof1);
			
			System.out.println("FIM GRAVACAO MONGODB");
			
			
			System.out.println("INICIO GRAVACAO MONGODB usuario 2");
			
			Profissional prof2 = new Profissional();
			prof2.setNome("usuario 2");
			prof2.setCpf("12345678922");
			prof2.setDataInclusao("19/02/2022");
			prof2.setFuncao("Arquiteto");
			prof2.setLogin("usuario 2");
			prof2.setSenha("123456");
			profissionalRepository.save(prof2);
			
			System.out.println("FIM GRAVACAO MONGODB");
			
		
			System.out.println("INICIO UPDATE usuario 2");
			
			Profissional prof3  = profissionalRepository.pesquisarPorLogin("usuario 2");
			prof3.setNome("usuário 2 com nome alterado");
			profissionalRepository.save(prof3);
			
			System.out.println("FIM UPDATE usuario 2");
			
			System.out.println("INICIO LISTAR TODOS");
			profissionalRepository.findAll().forEach(item -> System.out.println(item));
			System.out.println("FIM LISTAR TODOS");
			
			System.out.println("INICIO DELETAR");
			Profissional profDel = profissionalRepository.pesquisarPorLogin("gilberto");
			profissionalRepository.delete(profDel);
			System.out.println("TEMRINO DELETAR");
			
		} catch (Exception e) {
			System.out.println(e);
			return "Erro durante a gravacao";
		}
		*/
	
		return "Ola mundo Spring";
	}
	

}
