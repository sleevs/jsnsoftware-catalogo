package br.com.jsn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsn.entity.UsuarioEntity;
import br.com.jsn.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	
	@Autowired
    private UsuarioService usuarioService ;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<String> listarUsuarios(){
		
		try {
			String result = usuarioService.listar();
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}

}
