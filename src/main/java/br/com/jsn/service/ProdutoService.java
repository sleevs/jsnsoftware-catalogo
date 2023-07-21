package br.com.jsn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jsn.entity.ProdutoEntity;
import br.com.jsn.repository.ProdutoRepository;

@Service
public class ProdutoService  implements Crud<ProdutoEntity> {
	
	@Autowired
	private ProdutoRepository produtoRepository ;
	
	

	@Override
	public String criar(ProdutoEntity data) {
		
		String result = null ;
		ObjectMapper objectMapper = new ObjectMapper();
		ProdutoEntity novoProduto = null ;
		try {
		//	novoProduto =	objectMapper.readValue(data , ProdutoEntity.class);
			 novoProduto = produtoRepository.saveAndFlush(data);
			 result = objectMapper.writeValueAsString(novoProduto);
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
			 result = objectMapper.writeValueAsString(produtoRepository.findAll());
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
		
		try {
			 result = objectMapper.writeValueAsString(produtoRepository.buscarProdutoPorId(id));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		return result;
	}


	@Override
	public void deletar(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String atualizar(ProdutoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
