package br.com.jsn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jsn.entity.UsuarioEntity;
@Repository 
public interface UsuarioRepository extends JpaRepository<UsuarioEntity , Long>{

	@Query(value = "SELECT * FROM usuario WHERE usuario_id =?1",  nativeQuery = true) UsuarioEntity buscarUsuario(Integer id);
	
}
