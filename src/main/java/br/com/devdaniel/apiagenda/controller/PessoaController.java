package br.com.devdaniel.apiagenda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devdaniel.apiagenda.Service.PessoaService;
import br.com.devdaniel.apiagenda.config.SwaggerConfig;
import br.com.devdaniel.apiagenda.entities.Pessoa;
import br.com.devdaniel.apiagenda.entities.dto.PessoaDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin()
@Api(tags = { SwaggerConfig.PESSOA_TAG })
@RestController
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	private PessoaService service;

	
	@ApiOperation(value = "Listagem de todas as pessoas cadastradas!")
	@GetMapping(value = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PessoaDto>> findAll() {
		List<PessoaDto> pessoas = service.findAll();
		return ResponseEntity.ok().body(pessoas);
	}

	@ApiOperation(value = "Cadastrar Pessoa!")
	@PostMapping(value = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaDto> save(@Valid @RequestBody PessoaDto dto) {
		service.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@ApiOperation(value = "Buscar Pessoa por nome completo ou parte do nome!")
	@GetMapping(value = "pessoas/nomes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PessoaDto>> finByName(@RequestParam("nome") String nome) {
		List<PessoaDto> obj = service.findByName(nome);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Deletar pessoa da agenda!")
	@DeleteMapping(value = "/pessoas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteleById(@PathVariable long id) {
		service.deleteById(id);
	}

	@ApiOperation(value = "Atualizando uma pessoa da agenda!")
	@PutMapping(value = "/pessoas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaDto> update(@Valid @RequestBody PessoaDto dto, @PathVariable long id) {
		service.update(dto, id);
		return ResponseEntity.ok().body(dto);
	}

	@ApiOperation(value = "Buscando pessoa por id!")
	@GetMapping(value = "/pessoas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaDto> findById(@PathVariable long id) {
		Pessoa obj = service.findById(id);
		PessoaDto objDto = new PessoaDto(obj);
		return ResponseEntity.ok().body(objDto);
	}
}
