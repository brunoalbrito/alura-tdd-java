package br.com.alura.dominio;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class Leilao {
	@Getter
	private String descricao;

	@Getter
	private List<Lance> lances;

	public Leilao(String descricao) {
		super();
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(final Lance lance) {
		lances.add(lance);
	}
}
