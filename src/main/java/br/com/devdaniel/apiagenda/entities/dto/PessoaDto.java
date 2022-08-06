package br.com.devdaniel.apiagenda.entities.dto;

import br.com.devdaniel.apiagenda.entities.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaDto {

	private String nome;
	private String email;
	private String telefone;
	
	public PessoaDto (Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
	}
	
}
