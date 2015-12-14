package br.ufc.banco.persistencia;

import java.io.File;
import java.io.Serializable;

import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.ArrayContas;
import br.ufc.banco.dados.IRepositorioContas;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class BancoDAO implements IRepositorioContas, Serializable {
	ArrayContas contas;
	File arquivo;

	public BancoDAO(String path) {
		this.arquivo = new File(path);

		if (this.arquivo.exists()) {
			try {
				contas = (ArrayContas) Descerializador.descerializar(path);
			} catch (Exception e) {
				System.out.println("ERROR: Impossivel abrir o arquivo");
				e.printStackTrace();
			}
		} else {
			contas = new ArrayContas();
		}
	}

	@Override
	public void inserir(ContaAbstrata conta) throws CEException {
		contas.inserir(conta);
		salvar();
	}

	@Override
	public void apagar(String numero) throws CIException {
		contas.apagar(numero);
		salvar();
	}

	@Override
	public ContaAbstrata procurar(String numero) {
		return contas.procurar(numero);
	}

	@Override
	public ContaAbstrata[] listar() {
		return contas.listar();
	}

	@Override
	public int numeroContas() {
		return contas.numeroContas();
	}

	public void salvar() {
		try {
			Serializador.serializar(arquivo.getPath(), contas);
		} catch (Exception e) {
			System.out.println("ERROR: Impossivel salvar arquivo");
			e.printStackTrace();
		}

	}

}
