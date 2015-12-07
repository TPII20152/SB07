package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContaEspecialTest {
	
	ContaEspecial contaEspecial;
	String numConta = "1234";
	
	@Before
	public void setUp() {
		contaEspecial = new ContaEspecial(numConta);
	}
	
	@Test
	public void testCreditarNormal() {
		double valor = 10;
		contaEspecial.creditar(valor);
		
		assertEquals(valor, contaEspecial.obterSaldo(), 0);
	}
	
	@Test
	public void testCreditarNegativo() {
		double valor = -5;
		double saldoAnterior = contaEspecial.obterSaldo();
		contaEspecial.creditar(valor);
		
		assertEquals(saldoAnterior, contaEspecial.obterSaldo(), 0);
	}
	
	@Test
	public void testBonusNormal() {
		double valor = 100;
		double bonusEsperado = contaEspecial.obterBonus() + (valor * 0.01);
		contaEspecial.creditar(valor);
		
		assertEquals(bonusEsperado, contaEspecial.obterBonus(), 0);
	}
	
	@Test
	public void testBonusNegativo() {
		double valor = -100;
		double bonusEsperado = contaEspecial.obterBonus();
		contaEspecial.creditar(valor);
		
		assertEquals(bonusEsperado, contaEspecial.obterBonus(), 0);
	}
	
	@Test
	public void testRendeBonus() {
		double valor = 100;
		double saldoEsperado = valor + contaEspecial.obterBonus() + (valor * 0.01);
		contaEspecial.creditar(valor);
		contaEspecial.rendeBonus();
		
		assertEquals(saldoEsperado, contaEspecial.obterSaldo(), 0);
	}
}
