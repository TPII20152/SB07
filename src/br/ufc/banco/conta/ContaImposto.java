package br.ufc.banco.conta;

import java.io.Serializable;

import br.ufc.banco.conta.excecoes.SIException;

public class ContaImposto extends ContaAbstrata implements Serializable {

	public ContaImposto(String numero) {
		super(numero);
	}

	public void debitar(double valor) throws SIException {
		double debito = valor + (valor * 0.001);
		if (debito <= saldo) {
			this.saldo = this.saldo - debito;
		} else {
			throw new SIException(this.numero, this.saldo);
		}
	}
}
