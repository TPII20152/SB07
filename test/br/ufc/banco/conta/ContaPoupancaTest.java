package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContaPoupancaTest {

	@Test
	public void testRendeJuros() {
		ContaPoupanca conta = new ContaPoupanca("XXXXXXXXXXXXXX");
		conta.creditar(1000);
		
		conta.rendeJuros(0.01);
		
		assertEquals(1010, conta.obterSaldo(), 0.01);
	}

}
