package br.com.jsn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsn.entity.ProdutoEntity;
import br.com.jsn.service.ProdutoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService ;
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value = "/criar", consumes = {"application/json"}) 
	public ResponseEntity<String> criarProduto(@RequestBody ProdutoEntity produto){
		
		try {
			String result = produtoService.criar(produto);
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<String> listarProduto(){
		
		try {
			String result = produtoService.listar();
			return ResponseEntity.ok(result);
			
		}catch(Exception e){
			return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
		}
		
	}

}


