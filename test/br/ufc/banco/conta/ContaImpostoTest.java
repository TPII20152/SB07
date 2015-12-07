package br.ufc.banco.conta;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.contas.ContaImposto;

public class ContaImpostoTest {
	ContaImposto conta;
	
	@Before
	public void setup() {
		conta = new ContaImposto("1");
	}
	
	@Test
	public void testDebitarNormal() {
		conta.creditar(100);
		conta.debitar(50);
		assertEquals(50-(50*0.001), conta.obterSaldo(), 0.0001);
	}
	
	@Test
	public void testDebitarNegativo() {
		conta.debitar(-50);
		assertEquals(0, (int)conta.obterSaldo());
	}
	
	@After
	public void tearDown() {
		
	}
}
