package br.ufc.banco.dados;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class VectorContasTest {
	VectorContas contas;
	 
	@Before
	public void setUp() throws Exception {
		contas = new VectorContas();
	}
	
	@Test
	public void testNumeroContasVazio() {
		assertEquals(0, contas.numeroContas());
	}
	
	@Test
	public void testNumeroContasPositivo() throws CEException {
		contas.inserir(new Conta("1234"));
		assertEquals(1, contas.numeroContas());
	}

	@Test (expected = CEException.class)
	public void testInserirDuplicata() throws CEException {
		contas.inserir(new Conta("1234"));
		contas.inserir(new Conta("1234"));
	}
	
	@Test
	public void testProcurarNaoExistente() {
		assertEquals(null,contas.procurar("1234"));
	}
	
	@Test
	public void testProcurarExistente() throws CEException {
		String numConta = "1234";
		Conta conta = new Conta(numConta);
		contas.inserir(conta);
		assertEquals(conta.obterNumero(),contas.procurar(numConta).obterNumero());
	}
	
	@Test (expected = CIException.class)
	public void testApagarNaoExistente() throws CIException {
		contas.apagar("1234");
	}

	@Test
	public void testApagarExistente() {
		String numConta = "1234";
		Conta conta = new Conta(numConta);
		try {
			contas.inserir(conta);
			contas.apagar(numConta);
			assertEquals(null, contas.procurar(numConta));
		} catch (CEException | CIException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testListar() {
		ContaAbstrata[] contaVetor = new Conta[10];
		try {
			for (int i = 0; i < 10; i++) {
				contaVetor[i] = new Conta(""+i);
				contas.inserir(contaVetor[i]);				
			}
			
			assertEquals(contaVetor, contas.listar());
		} catch (CEException e) {
			e.printStackTrace();
		}
		
		
	}
}
