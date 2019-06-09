package br.com.alura.teste;

import br.com.alura.dominio.Lance;
import br.com.alura.dominio.Leilao;
import br.com.alura.dominio.Usuario;
import br.com.alura.service.Avaliador;

public class TesteAvaliador {

	public static void main(String[] args) {
		Usuario joao = new Usuario(0, "João");
		Usuario maria = new Usuario(1, "Maria");
		Usuario jose = new Usuario(2, "José");

		Leilao leilao = new Leilao("Playstation 4 novo");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(jose, 250.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		System.out.println(leiloeiro.getMaiorDeTodos());
		System.out.println(leiloeiro.getMenorDeTodos());
	}

}
