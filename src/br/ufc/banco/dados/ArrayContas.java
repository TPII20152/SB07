package br.ufc.banco.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class ArrayContas implements IRepositorioContas {

	private List<ContaAbstrata> contas;

	public ArrayContas() {
		this.contas = new ArrayList<ContaAbstrata>();
	}

	public void apagar(String numero) throws CIException {
		if (contas.contains(new Conta(numero))) {
			contas.remove(new Conta(numero));
		} else {
			throw new CIException(numero);
		}
	}

	public void inserir(ContaAbstrata conta) throws CEException {
		if (this.procurar(conta.obterNumero()) == null) {
			contas.add(conta);
		} else {
			throw new CEException(conta.obterNumero());
		}
	}

	public ContaAbstrata[] listar() {
		ContaAbstrata[] lista = null;
		if (contas.size() > 0) {
			lista = new ContaAbstrata[contas.size()];
			for (int i = 0; i < contas.size(); i++) {
				lista[i] = contas.get(i);
			}
		}
		return lista;
	}

	public int numeroContas() {
		return contas.size();
	}

	public ContaAbstrata procurar(String numero) {
		if (contas.size() > 0) {
			int i = contas.indexOf(new Conta(numero));
			return contas.get(i);
		}
		return null;
	}
}
