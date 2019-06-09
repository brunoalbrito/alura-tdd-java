package br.com.alura.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.dominio.Lance;
import br.com.alura.dominio.Leilao;
import br.com.alura.dominio.Usuario;
import br.com.alura.service.Avaliador;

public class AvaliadorTeste {

	@Test
	public void deveEntenderLancesComValoresAleatorios() {
		Usuario joao = new Usuario(0, "João");
		Usuario maria = new Usuario(1, "Maria");
		Usuario jose = new Usuario(2, "José");

		Leilao leilao = new Leilao("Playstation 4 novo");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(jose, 250.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(400, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(250, leiloeiro.getMenorDeTodos(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario(0, "João");
		Usuario maria = new Usuario(1, "Maria");
		Usuario jose = new Usuario(2, "José");

		Leilao leilao = new Leilao("Playstation 4 novo");

		leilao.propoe(new Lance(jose, 100.0));
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(maria, 300.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(300, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(100, leiloeiro.getMenorDeTodos(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrecente() {
		Usuario joao = new Usuario(0, "João");
		Usuario maria = new Usuario(1, "Maria");
		Usuario jose = new Usuario(2, "José");

		Leilao leilao = new Leilao("Playstation 4 novo");

		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 200.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(400, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(200, leiloeiro.getMenorDeTodos(), 0.0001);
	}

	@Test
	public void deveEntenderMediaLances() {
		Usuario joao = new Usuario(0, "João");
		Usuario maria = new Usuario(1, "Maria");
		Usuario jose = new Usuario(2, "José");

		Leilao leilao = new Leilao("Xbox One");
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 300.0));
		leilao.propoe(new Lance(jose, 500.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(300.0, leiloeiro.getMedia(), 0.0001);
	}
	
	@Test
	public void deveEntenderMediaLancesComLancesSemValor() {
		Usuario joao = new Usuario(0, "João");
		Usuario maria = new Usuario(1, "Maria");
		Usuario jose = new Usuario(2, "José");

		Leilao leilao = new Leilao("Xbox One");
		leilao.propoe(new Lance(joao, 0.0));
		leilao.propoe(new Lance(maria, 0.0));
		leilao.propoe(new Lance(jose, 0.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(0.0, leiloeiro.getMedia(), 0.0001);
	}
	
	@Test
	public void deveEntenderLeilaoSemLances() {
		Leilao leilao = new Leilao("Xbox One");

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(0.0, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(0.0, leiloeiro.getMenorDeTodos(), 0.0001);
		assertEquals(0.0, leiloeiro.getMedia(), 0.0001);
	}
}
