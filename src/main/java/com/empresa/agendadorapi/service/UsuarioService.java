package com.empresa.agendadorapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.empresa.agendadorapi.dto.UsuarioDTO;
import com.empresa.agendadorapi.dto.mapper.MapeadorDto;
import com.empresa.agendadorapi.model.Usuario;
import com.empresa.agendadorapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	MapeadorDto mapeadorDto;
	
	@Autowired	
	UsuarioRepository usuarioTemplate;
	
	public UsuarioDTO incluirUsuario(UsuarioDTO dto) {
		
		Usuario usuario =  mapeadorDto.usuarioDtoToUsuario(dto);
		Usuario profResult = usuarioTemplate.incluirUsuario(usuario);		
		return mapeadorDto.usuarioToUsuarioDto(profResult);
	}
	
	public List<UsuarioDTO> listarTodos(){
		
		List <Usuario> usuariosBanco = usuarioTemplate.listarTodos();
		List<UsuarioDTO> usuariosDTO  = new ArrayList<UsuarioDTO>();  
			
			for (Usuario user: usuariosBanco ) {
				UsuarioDTO profDTO = mapeadorDto.usuarioToUsuarioDto(user);
				usuariosDTO.add(profDTO);								
			}
			return usuariosDTO;
	}
	
	public void atualizarUsuario(UsuarioDTO dto) {
		
		Usuario Usuario = mapeadorDto.usuarioDtoToUsuario(dto);
		usuarioTemplate.atualizarUsuario(Usuario);

	}
	
	public void deletarUsuario(String id) {
		try {
			usuarioTemplate.deletarUsuario(id);	
									
		} catch (Exception e) {
			throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, "Erro no servidor ao deletar funcionario.");
		}
				
	}
	
	public UsuarioDTO pesquisarPorId (String id) {
		
		try { 
		Usuario usario = usuarioTemplate.pesquisarPorId(id);
		UsuarioDTO dto;
		
		if (usario != null) {
		
			dto = mapeadorDto.usuarioToUsuarioDto(usario); 
		
		}else {
			throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Recurso não encontrado");
		}
		
		return dto;
		
		}catch (Exception e) {
			throw new ResponseStatusException (HttpStatus.BAD_REQUEST, "Erro ao salvar informações do Usuario");
		
		}
		
	}
	
}
