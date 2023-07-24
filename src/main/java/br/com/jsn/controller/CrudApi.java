package br.com.jsn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.jsn.entity.ProdutoEntity;
import br.com.jsn.entity.UsuarioEntity;

public interface CrudApi<T> {
	
	

	@PostMapping("/criar") 
	public ResponseEntity<String> criar(@RequestBody T produto);
	
	@GetMapping("/listar")
	public ResponseEntity<String> listar();
	
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<String> buscar(@PathVariable Integer id);
	


	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizar(@RequestBody T usuario );
	
	

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id);

}
