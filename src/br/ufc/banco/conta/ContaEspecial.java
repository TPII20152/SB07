package br.ufc.banco.conta;

import java.io.Serializable;

public class ContaEspecial extends Conta implements Serializable {

	private double bonus;

	public ContaEspecial(String numero) {
		super(numero);
		bonus = 0;
	}

	public void rendeBonus() {
		super.creditar(bonus);
		bonus = 0;
	}

	public double obterBonus() {
		return bonus;
	}

	public void creditar(double valor) {
		bonus = bonus + (valor * 0.01);
		super.creditar(valor);
	}

}
