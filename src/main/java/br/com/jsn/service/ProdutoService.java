package br.com.jsn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jsn.entity.ProdutoEntity;
import br.com.jsn.entity.UsuarioEntity;
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
		ProdutoEntity novoProduto = null ;
		try {
		
			 novoProduto = produtoRepository.buscarProdutoPorId(id);
			 result = objectMapper.writeValueAsString(novoProduto);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
			return result ;
	}


	@Override
	public void deletar(Integer id) {
		
		try {
			produtoRepository.deleteById(id.longValue());
			} catch (Exception e) {
				
				e.printStackTrace();
				e.getMessage();
			}
		
	}


	@Override
	public String atualizar(ProdutoEntity data) {
		String result = null ;
		ObjectMapper objectMapper = new ObjectMapper();
		ProdutoEntity updateProduto = null ;
		try {
			updateProduto = produtoRepository.findById(data.getProdutoId().longValue())
			            .map(produto -> {
			                
			            	produto.setProdutoFornecedor(data.getProdutoFornecedor());
			            	produto.setProdutoNome(data.getProdutoNome());
			                produto.setProdutoValor(data.getProdutoValor());
			                return produtoRepository.save(produto);
			            })
			            .orElseGet(() -> {
			                return produtoRepository.saveAndFlush(data);
			            });
			
			 result = objectMapper.writeValueAsString(updateProduto);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
			return result ;
	}

}
