package br.com.jsn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.jsn.entity.ProdutoEntity;

@Repository 
public interface ProdutoRepository extends JpaRepository<ProdutoEntity , Long>{

	@Query(value = "SELECT * FROM produto WHERE usuario_id =?1",  nativeQuery = true) List<ProdutoEntity> buscarProdutoPorUsuario(Integer id);

	@Query(value = "SELECT * FROM produto WHERE produto_id =?1",  nativeQuery = true) ProdutoEntity buscarProdutoPorId(Integer id);

}
