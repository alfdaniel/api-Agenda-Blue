package br.com.devdaniel.apiagenda.entities.dto;

import br.com.devdaniel.apiagenda.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	
	public PessoaDto (Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
	}
	
}
