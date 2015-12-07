package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.excecoes.SIException;

public class ContaTest {
	Conta conta;
	String numConta = "123";
	
	@Before
	public void setUp() {
		conta = new Conta(numConta);
	}

	@Test
	public void testCreditarNormal() {
		double valor = 10;
		conta.creditar(valor);
		
		assertEquals(valor, conta.obterSaldo(), 0);
	}
	
	@Test
	public void testCreditarNegativo() {
		double valor = -5;
		double saldoanterior = conta.obterSaldo();
		conta.creditar(valor);
		
		assertEquals(saldoanterior, conta.obterSaldo(), 0);
	}
	
	@Test
	public void testDebitarNormal() {
		double valor = 5;
		double saldoAnterior = conta.obterSaldo();
		double saldoEsperado = saldoAnterior - valor;
		try {
			conta.debitar(valor);
			assertEquals(saldoEsperado, conta.obterSaldo(), 0);
		} catch (SIException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDebitarNegativo() {
		double valor = -5;
		double saldoAnterior = conta.obterSaldo();
		try {
			conta.debitar(valor);
			assertEquals(saldoAnterior, conta.obterSaldo(), 0);
		} catch (SIException e) {
			e.printStackTrace();
		}
	}

}
