package br.com.devdaniel.apiagenda.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.devdaniel.apiagenda.Service.PessoaService;
import br.com.devdaniel.apiagenda.config.ModelMapperConfig;
import br.com.devdaniel.apiagenda.entities.Pessoa;
import br.com.devdaniel.apiagenda.entities.dto.PessoaDto;

@SpringBootTest
public class PessoaControllerImplTest {

	@InjectMocks
	private PessoaController controller;
	
	@Mock
	private PessoaService service;
	
	@Mock
	private ModelMapperConfig mapper;
	
	private Pessoa pessoa;
	private PessoaDto pessoaDto;

	private static final Long ID = 1L;
	private static final String NOME = "daniel";
	private static final String EMAIL = "daniel@gmail";
	private static final String TELEFONE = "9999-8888";
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		iniciandoMockPessoa();
	}
	
	@Test
	public void finAll() {
		
	}
	
	private void iniciandoMockPessoa() {
		pessoa = new Pessoa(ID, NOME, EMAIL, TELEFONE);
		pessoaDto = new PessoaDto(ID, NOME, EMAIL, TELEFONE);
	}
	
}
