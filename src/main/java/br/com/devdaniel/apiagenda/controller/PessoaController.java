package br.com.devdaniel.apiagenda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

@Api(tags = {SwaggerConfig.PESSOA_TAG})
@RestController
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@ApiOperation(value="Listagem de todas as pessoas cadastradas")
	@GetMapping(value="/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PessoaDto>> findAll(){
		List<PessoaDto> pessoas = service.findAll();
		return ResponseEntity.ok().body(pessoas);
	}

	@ApiOperation(value="Cadastrar Pessoa")
	@PostMapping(value="/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaDto> save(@Valid @RequestBody PessoaDto dto){
		service.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@ApiOperation(value="Buscar Pessoa por nome")
	@GetMapping(value = "/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaDto> finByName(@RequestParam("nome") String nome) {
		Pessoa obj = service.findByName(nome);
		PessoaDto objDto = new PessoaDto(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
}
