package br.com.devdaniel.apiagenda.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.devdaniel.apiagenda.entities.dto.PessoaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pessoas")
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	@NotBlank @Email
	private String email;
	@NotBlank
	private String telefone;
	
	public Pessoa(PessoaDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.email = dto.getEmail();
		this.telefone = dto.getTelefone();
	}

}
