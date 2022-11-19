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

	public List<Transacoes> nConta(int conta) {
		return this.nConta(conta);
	}

	public List<Transacoes> valorDeposito(double valor) {
		List<Transacoes> valorDeposito = new ArrayList<>();
		this.valorDeposito(valor);
		valorDeposito.add((Transacoes) valorDeposito(valor));
		return valorDeposito ;
	}

	public List<Transacoes> contaDestino(int contaDestino) {
		List<Transacoes> contaDestinoDep = new ArrayList<>();
		this.contaDestino(contaDestino);
		contaDestinoDep.add((Transacoes) contaDestino(contaDestino));
		return contaDestinoDep;
	}

	public List<Transacoes> valorTranferenciaTED(double valor) {
		return this.valorTranferenciaTED(valor);
	}

	public List<Transacoes> time(int tempo) {
		return this.time(tempo);
	}

	public List<Transacoes> valorTranferenciaDOC(double valor) {
		return	this.valorTranferenciaDOC(valor);
	}

	
}
