package br.com.devdaniel.apiagenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.devdaniel.apiagenda.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	@Query(value = "SELECT * FROM pessoas e WHERE e.nome like %:nome%", nativeQuery = true)
	Optional<Pessoa> findByName(@Param("nome") String nome);
	
}
