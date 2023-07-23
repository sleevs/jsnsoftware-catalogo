package br.com.jsn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.jsn.entity.UsuarioEntity;
import br.com.jsn.repository.UsuarioRepository;

@Service
public class UsuarioService  implements Crud<UsuarioEntity> {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository ;


	@Override
	public String criar(UsuarioEntity data) {
		String result = null ;
		ObjectMapper objectMapper = new ObjectMapper();
		UsuarioEntity novoUsuario = null ;
		try {
		
			novoUsuario = usuarioRepository.saveAndFlush(data);
			 result = objectMapper.writeValueAsString(novoUsuario);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
			return result ;
	}
		
		
	@Override
	public String listar() {
		
		String result = null ;
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			 result = objectMapper.writeValueAsString(usuarioRepository.findAll());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		return result ;
	}
	@Override
	public String encontrar(Integer id) {
		String result = null ;
		ObjectMapper objectMapper = new ObjectMapper();
		UsuarioEntity novoUsuario = null ;
		try {
			
			novoUsuario = usuarioRepository.buscarUsuario(id);
			 result = objectMapper.writeValueAsString(novoUsuario);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
			return result ;
	}
	@Override
	public void deletar(Integer id) {
		
		try {
	
			usuarioRepository.deleteById(id.longValue());
		} catch (Exception e) {
				
				e.printStackTrace();
				e.getMessage();
			}
		
	}
	@Override
	public String atualizar(UsuarioEntity data) {
		
		String result = null ;
		ObjectMapper objectMapper = new ObjectMapper();
		UsuarioEntity updateUsuario = null ;
		try {
			updateUsuario = usuarioRepository.findById(data.getUsuarioId().longValue())
			            .map(usuario -> {
			                
			            	usuario.setUsuarioEmail(data.getUsuarioEmail());
			            	usuario.setUsuarioNome(data.getUsuarioNome());
			            	usuario.setUsuarioSenha(data.getUsuarioSenha());
			                return usuarioRepository.save(usuario);
			            })
			            .orElseGet(() -> {
			                return usuarioRepository.saveAndFlush(data);
			            });
			
			 result = objectMapper.writeValueAsString(updateUsuario);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
			return result ;
	}
}
