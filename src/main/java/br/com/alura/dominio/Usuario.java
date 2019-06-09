package br.com.alura.dominio;

import lombok.Getter;

public class Usuario {

	@Getter
	private int id;

	@Getter
	private String nome;

	public Usuario(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
}
