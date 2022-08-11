package br.com.devdaniel.apiagenda.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.devdaniel.apiagenda.Service.PessoaService;
import br.com.devdaniel.apiagenda.entities.Pessoa;
import br.com.devdaniel.apiagenda.entities.dto.PessoaDto;

@SpringBootTest
public class PessoaControllerImplTest {

	@InjectMocks
	private PessoaController controller;
	
	@Mock
	private PessoaService service;
	
	@Mock
	private ModelMapper mapper;
	
	private Pessoa pessoa;
	private PessoaDto pessoaDto;
	
	private static final Long ID = 1L;
	private static final String NOME = "daniel";
	private static final String EMAIL = "daniel@gmail";
	private static final String TELEFONE = "9999-8888";
	private static final int INDEX = 0;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		iniciandoMockPessoa();
	}
	
	@Test
	public void buscarListaPessoasCadastradasComSucesso() {
		when(service.findAll()).thenReturn(List.of(pessoaDto));
		when(mapper.map(any(), any())).thenReturn(pessoaDto);
		
		ResponseEntity<List<PessoaDto>> dtos = controller.findAll();
		assertNotNull(dtos.getBody());
		assertNotNull(dtos);
		assertEquals(HttpStatus.OK, dtos.getStatusCode());
		assertEquals(ResponseEntity.class, dtos.getClass());
		
	}
	
	@Test
	public void inserindPessoaComSucesso() {
		when(service.save(any())).thenReturn(pessoa);
		
		ResponseEntity<PessoaDto> dtos = controller.save(pessoaDto);
		assertNotNull(dtos);
		assertEquals(HttpStatus.CREATED, dtos.getStatusCode());
		assertEquals(ResponseEntity.class, dtos.getClass());
				
	}
	
	@Test
	private void buscandoPessoaPorNome(){
	}
	
	@Test
	public void deletandoPessoaPorIdcomSucesso(){
	}
	
	@Test
	public void atualizandoPessoaCadastrada() {
		when(service.findById(anyLong())).thenReturn(pessoa);
		when(mapper.map(any(), any())).thenReturn(pessoaDto);
		
		ResponseEntity<PessoaDto> atulaizarPessoa = controller.update(pessoaDto, ID);
		assertNotNull(atulaizarPessoa);
		assertNotNull(atulaizarPessoa.getBody());
		assertEquals(ResponseEntity.class, atulaizarPessoa.getClass());
		assertEquals(PessoaDto.class, atulaizarPessoa.getBody().getClass());

		assertEquals(ID, atulaizarPessoa.getBody().getId());
		assertEquals(NOME, atulaizarPessoa.getBody().getNome());
		assertEquals(EMAIL, atulaizarPessoa.getBody().getEmail());
		assertEquals(TELEFONE, atulaizarPessoa.getBody().getTelefone());
	}
	
	@Test
	public void buscarPessoaPorIdComSucesso() {
		when(service.findById(anyLong())).thenReturn(pessoa);
		when(mapper.map(any(), any())).thenReturn(pessoaDto);
		
		ResponseEntity<PessoaDto> dto = controller.findById(ID);
		assertNotNull(dto);
		assertNotNull(dto.getBody());
		assertEquals(ResponseEntity.class, dto.getClass());
		assertEquals(PessoaDto.class, dto.getBody().getClass());
		assertEquals(HttpStatus.OK, dto.getStatusCode());
		
		assertEquals(ID, dto.getBody().getId());
		assertEquals(NOME, dto.getBody().getNome());
		assertEquals(EMAIL, dto.getBody().getEmail());
		assertEquals(TELEFONE, dto.getBody().getTelefone());
		
		
	}
	
	private void iniciandoMockPessoa() {
		pessoa = new Pessoa(ID, NOME, EMAIL, TELEFONE);
		pessoaDto = new PessoaDto(ID, NOME, EMAIL, TELEFONE);
	}
	
	
	
}
