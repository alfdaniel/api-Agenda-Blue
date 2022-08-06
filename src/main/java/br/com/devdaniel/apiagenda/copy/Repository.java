package br.com.devdaniel.apiagenda.copy;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devdaniel.apiagenda.entities.Pessoa;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Pessoa, Long>{

}
