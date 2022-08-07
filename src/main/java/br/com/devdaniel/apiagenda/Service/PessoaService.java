package br.com.devdaniel.apiagenda.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devdaniel.apiagenda.entities.Pessoa;
import br.com.devdaniel.apiagenda.entities.dto.PessoaDto;
import br.com.devdaniel.apiagenda.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<PessoaDto> findAll(){
		List<Pessoa> pessoas =  repository.findAll();
		return pessoas.stream().map(x -> new PessoaDto(x)).collect(Collectors.toList());
	}
	
}
