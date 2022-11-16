package app.bank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContaPJ extends ContaBancaria{
	private ClientePJ clientePJ;
	
	private boolean ativado, desativado;
	private int senha;
	
	
	public ContaPJ contaPJ(int contaPJ) {
		//ClientePJ contaPJpj = getClientePJ();
		return contaPJ(contaPJ);
	}
	
	
	public boolean setClientePJ(String cnpj) {
		
		return true;
	}
	
	public double setSaldo(double saldo) {
		return saldo;
	}
	
	
	public ClientePJ clientePJ(ClientePJ clientePJ) {
		return clientePJ = this.clientePJ;
	}
	
	public boolean setSenha(int senha) {
		return true;
	}

	public String setClientePJ(boolean setCNPJ) {
		// TODO Auto-generated method stub
		return null;
	}


	public ContaPJ debito(int[] nCartao) {
		ContaPJ contaPj = getContaPJ();
		int contaPJ = getNumeroContaBancaria();
		contaPj.setContaPJ(contaPJ);
		return contaPj;
	}


	private void setContaPJ(int contaPJ) {
		this.contaPJ(contaPJ);
	}


	private ContaPJ getContaPJ() {
		return getContaPJ();
	}


	public void credito(int[] nCartao) {
		// TODO Auto-generated method stub
		
	}
	
	
}
