package br.com.jsn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jsn.dto.LoginRequest;
import br.com.jsn.entity.ProdutoEntity;
import br.com.jsn.entity.UsuarioEntity;
import br.com.jsn.repository.UsuarioRepository;

@Service
public class LoginService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository ;
	
	public String login(LoginRequest loginRequest) {
		
		String result = null ;
		ObjectMapper objectMapper = new ObjectMapper();
		UsuarioEntity usuarioEntity = null ;
		try {
		
			usuarioEntity =	usuarioRepository.buscarUsuarioEmailSenha(loginRequest.getLoginRequestEmail(), loginRequest.getLoginRequestSenha());
		
			 result = objectMapper.writeValueAsString(usuarioEntity);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
			return result ;
		
		
	}

}
