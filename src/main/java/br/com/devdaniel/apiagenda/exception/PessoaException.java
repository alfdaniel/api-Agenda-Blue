package br.com.devdaniel.apiagenda.exception;

public class PessoaException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public PessoaException(String msg) {
		super(msg);
	}

}
