package app.bank.model;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ContaBancaria {
	
	@Id
	private int numeroContaBancaria;
	
	
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
	
	
	
}
