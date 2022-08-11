package br.com.devdaniel.apiagenda.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devdaniel.apiagenda.entities.Pessoa;
import br.com.devdaniel.apiagenda.entities.dto.PessoaDto;
import br.com.devdaniel.apiagenda.exception.PessoaException;
import br.com.devdaniel.apiagenda.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	// buscar todas as pessoas da agenda
	public List<PessoaDto> findAll() {
		List<Pessoa> pessoas = repository.findAll();
		return pessoas.stream().map(x -> new PessoaDto(x)).collect(Collectors.toList());
	}

	// salvar uma nova pessoa
	public Pessoa save(PessoaDto dto) {
		Pessoa obj = new Pessoa(dto);
		repository.save(obj);
		return obj;
	}

	// buscar pessoa por nome com native query
	public List<PessoaDto> findByName(String nome) {
		List<Pessoa> pessoas = repository.findByName(nome);
		if (pessoas.isEmpty()) {
			throw new PessoaException("Pessoa não encontrada!");
		}
		return pessoas.stream().map(x -> new PessoaDto(x)).collect(Collectors.toList());
	}

	// deletar pessoa por ID
	public void deleteById(long id) throws PessoaException {
		Optional<Pessoa> obj = repository.findById(id);
		if (obj.isEmpty()) {
			throw new PessoaException("Pessoa não encontrada!");
		}
		repository.deleteById(id);
	}
	
	// atualizar pessoa da agenda
	public void update(PessoaDto pessoaDto, long id) throws PessoaException {
		Optional<Pessoa> objPessoa = repository.findById(id);
		if (objPessoa.isEmpty()) {
			throw new PessoaException("Pessoa não encontrada!");
		}

		objPessoa.map(record -> {
			record.setNome(pessoaDto.getNome());
			record.setEmail(pessoaDto.getEmail());
			record.setTelefone(pessoaDto.getTelefone());
			Pessoa pessoa = repository.save(record);
			return pessoa;
		});
	}

	// buscar pessoa por Id
	public Pessoa findById(long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new PessoaException("Pessoa não encontrada!"));
	}
	
	
	
}
