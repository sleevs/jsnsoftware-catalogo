package br.com.jsn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.jsn.entity.ProdutoEntity;
import br.com.jsn.service.ProdutoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController implements CrudApi<ProdutoEntity>{
	
	@Autowired
	private ProdutoService produtoService ;
	
	
	public ResponseEntity<String> criar(@RequestBody ProdutoEntity produto){
		
		try {
			String result = produtoService.criar(produto);
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public ResponseEntity<String> listar(){
		
		try {
			String result = produtoService.listar();
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

	
	
	public ResponseEntity<String> buscar(@PathVariable Integer id){
		
		try {
			String result = produtoService.encontrar(id);
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

	
	public ResponseEntity<String> atualizar(@RequestBody ProdutoEntity produto ){
		
		try {
			String result = produtoService.atualizar(produto);
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	public ResponseEntity<String> deletar(@PathVariable Integer id){
		
		try {
			produtoService.deletar(id);
			return ResponseEntity.ok("OPERAÇÃO CONCLUÍDA");
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}

}


