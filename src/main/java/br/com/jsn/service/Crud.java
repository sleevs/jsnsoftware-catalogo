package br.com.jsn.service;

import java.util.List;

public interface Crud<T> {
	
	public String  criar(T data);	
	public String listar();
	public String encontrar(Integer id);
	public void deletar(Integer id);
	public String atualizar(T data);

}
