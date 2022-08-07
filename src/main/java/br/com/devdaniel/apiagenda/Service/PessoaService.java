package br.com.devdaniel.apiagenda.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

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
	
	public Pessoa save(PessoaDto dto){
		Pessoa obj = new Pessoa(dto); 
		repository.save(obj);
		return obj;
	}


	public Pessoa findByName(String nome){
		Optional<Pessoa> obj = repository.findByName(nome);
		obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa com nome " + nome + " não encontrado!"));
		return obj.get();
	}
	
}
