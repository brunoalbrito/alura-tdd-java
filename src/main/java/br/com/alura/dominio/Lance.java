package br.com.alura.dominio;

import lombok.Getter;

public class Lance {
	@Getter
	private Usuario usuario;
	
	@Getter
	private double valor;

	public Lance(Usuario usuario, double valor) {
		super();
		this.usuario = usuario;
		this.valor = valor;
	}
}
