package br.com.devdaniel.apiagenda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.devdaniel.apiagenda.Service.PessoaService;
import br.com.devdaniel.apiagenda.entities.Pessoa;
import br.com.devdaniel.apiagenda.entities.dto.PessoaDto;
import br.com.devdaniel.apiagenda.repository.PessoaRepository;

@SpringBootTest
public class PessoaServiceImplTest {

	@InjectMocks
	private PessoaService service;

	@Mock
	private PessoaRepository repository;

	private Pessoa pessoa;
	private PessoaDto pessoaDto;
	private Optional<Pessoa> optionalPessoa;

	private static final Long ID = 1L;
	private static final String NOME = "daniel";
	private static final String EMAIL = "daniel@gmail";
	private static final String TELEFONE = "9999-8888";
	
	private static final Integer INDEX = 0;

	private static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		startPessoa();
	}

	@Test
	public void buscarTodasPessoasCadastradas() {
		
		when(repository.findAll()).thenReturn(List.of(pessoa));
		
		List<PessoaDto> pessoaList = service.findAll();
		
		assertNotNull(pessoaList);
		assertEquals(1, pessoaList.size());
//		assertEquals(Pessoa.class, pessoaList.get(INDEX).getClass());
//		
//		assertEquals(ID, pessoaList.get(INDEX).getId());
//		assertEquals(NOME, pessoaList.get(INDEX).getNome());
//		assertEquals(EMAIL, pessoaList.get(INDEX).getEmail());
//		assertEquals(TELEFONE, pessoaList.get(INDEX).getTelefone());
	}
	
	@Test
	public void buscarPessoaPorId() {
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(optionalPessoa);
		
		Pessoa pessoaRetorno = service.findById(1);
		assertNotNull(pessoaRetorno);
		assertEquals(Pessoa.class, pessoaRetorno.getClass());
		
		assertEquals(ID, pessoaRetorno.getId());
		assertEquals(NOME, pessoaRetorno.getNome());
		assertEquals(EMAIL, pessoaRetorno.getEmail());
		assertEquals(TELEFONE, pessoaRetorno.getTelefone());
	}

	private void startPessoa() {
		pessoa = new Pessoa(ID, NOME, EMAIL, TELEFONE);
		pessoaDto = new PessoaDto(ID, NOME, EMAIL, TELEFONE);
		optionalPessoa = Optional.of(new Pessoa(ID, NOME, EMAIL, TELEFONE));
	}

}
