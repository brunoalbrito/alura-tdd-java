package br.com.alura.service;

import br.com.alura.dominio.Lance;
import br.com.alura.dominio.Leilao;
import lombok.Getter;

public class Avaliador {

	@Getter
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;

	@Getter
	private double menorDeTodos = Double.POSITIVE_INFINITY;

	@Getter
	private double media = 0.0;

	public void avalia(Leilao leilao) {
		if(verificaLeilaoNaoTemLances(leilao))
			return;
		maiorLance(leilao);
		menorLance(leilao);
		mediaLances(leilao);
	}

	private boolean verificaLeilaoNaoTemLances(Leilao leilao) {
		if (leilao.getLances().isEmpty()) {
			maiorDeTodos = 0.0;
			menorDeTodos = 0.0;
			return true;
		}
		return false;
	}

	private void menorLance(Leilao leilao) {
		for (Lance l : leilao.getLances()) {
			if (l.getValor() < menorDeTodos) {
				menorDeTodos = l.getValor();
			}
		}
	}

	private void maiorLance(Leilao leilao) {
		for (Lance l : leilao.getLances()) {
			if (l.getValor() > maiorDeTodos) {
				maiorDeTodos = l.getValor();
			}
		}
	}

	private void mediaLances(Leilao leilao) {
		double somaTotal = 0;
		for (Lance lance : leilao.getLances()) {
			somaTotal += lance.getValor();
		}
		int qtdLances = leilao.getLances().size();
		media = somaTotal / qtdLances;
	}
}