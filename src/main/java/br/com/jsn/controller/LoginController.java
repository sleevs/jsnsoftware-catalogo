package br.com.jsn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsn.dto.LoginRequest;
import br.com.jsn.entity.ProdutoEntity;
import br.com.jsn.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	

	@Autowired
	private LoginService loginService ;

	@PostMapping("/logar") 
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
		
		try {
			String result = loginService.login(loginRequest);
			
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	

}
