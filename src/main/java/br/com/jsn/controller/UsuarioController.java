package br.com.jsn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.jsn.entity.UsuarioEntity;
import br.com.jsn.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController implements CrudApi<UsuarioEntity>{
	
	
	@Autowired
    private UsuarioService usuarioService ;
	
	
	public ResponseEntity<String> criar(@RequestBody UsuarioEntity usuario){
		
		try {
			String result = usuarioService.criar(usuario);
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public ResponseEntity<String> listar(){
		
		try {
			String result = usuarioService.listar();
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	public ResponseEntity<String> buscar(@PathVariable Integer id){
		
		try {
			String result = usuarioService.encontrar(id);
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public ResponseEntity<String> atualizar(@RequestBody UsuarioEntity usuario ){
		
		try {
			String result = usuarioService.atualizar(usuario);
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public ResponseEntity<String> deletar(@PathVariable Integer id){
		
		try {
		 usuarioService.deletar(id);
			return ResponseEntity.ok("OPERAÇÃO CONCLUÍDA");
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
}
