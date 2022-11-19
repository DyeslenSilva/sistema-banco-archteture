package app.bank.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ContaBancaria {
	
	@Id
	private int numeroContaBancaria;
	
	private List<ContaPF> extratoBancarioPF;
	private List<ContaPJ> extratoBancarioPJ;
	
	
	List<Integer> nConta = new ArrayList<>();
	List<Boolean> senha = new ArrayList<>();
	private double saldoConta;
	private CaixaEletronico cxe;
	
	public boolean verificaSaldo(int nConta) {
		double saldoEmConta = getSaldoConta(nConta);
		if(saldoEmConta >0) {
			return true;
		}else {
			return false;
		}
	}	

	private double getSaldoConta(int nConta) {
		return this.saldoConta;
	}
	

	private boolean getSenha() {
		return true;
	}

	private int getNConta() {
		return this.numeroContaBancaria;
	}

	public Object nConta(int conta) {
		return this.nConta(conta);
	}

	public void valorDeposito(double valor) {
		this.valorDeposito(valor);
	}

	public void contaDestino(int contaDestino) {
		this.contaDestino(contaDestino);
	}

	public Object valorTranferenciaTED(double valor) {
		return this.valorTranferenciaTED(valor);
	}

	public void time(int tempo) {
		this.time(tempo);
	}

	public void valorTranferenciaDOC(double valor) {
		this.valorTranferenciaDOC(valor);
	}

	
}
