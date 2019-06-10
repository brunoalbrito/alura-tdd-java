package br.com.alura.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

	private List<Lance> maiores;

	public void avalia(Leilao leilao) {
		if (!verificaLeilaoNaoTemLances(leilao)) {
			maiorLance(leilao);
			menorLance(leilao);
			mediaLances(leilao);
			encontraOsTresMaiores(leilao);
		}
	}

	private void encontraOsTresMaiores(Leilao leilao) {
		maiores = new ArrayList<Lance>(leilao.getLances());

		maiores.sort(Comparator.comparing(Lance::getValor).reversed());

		maiores = maiores.subList(0, maiores.size() < 3 ? maiores.size() : 3);
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

	public List<Lance> getTresMaiores() {
		return maiores;
	}
}