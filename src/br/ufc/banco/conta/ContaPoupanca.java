package br.ufc.banco.conta;

import java.io.Serializable;

public class ContaPoupanca extends Conta implements Serializable {

	public ContaPoupanca(String numero) {
		super(numero);
	}

	public void rendeJuros(double taxa) {
		this.creditar(this.obterSaldo() * taxa);
	}
}
