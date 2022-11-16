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
		return Boolean.toString(setCNPJ);
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


	public ContaPJ credito(int[] nCartao) {
		ContaPJ contaPJ = getContaPJ();
		int nContaPJ = getNumeroContaBancaria();
		contaPJ.contaPJ(nContaPJ);
		return contaPJ;
	}


	public void debito(boolean setNCartao) {
		ContaPJ contaPj = getContaPJ();
		int contaPJ = getNumeroContaBancaria();
		contaPj.setContaPJ(contaPJ);
		return ;
	}


	public void credito(boolean setNCartao) {
		ContaPJ contaPj = getContaPJ();
		int contaPJ = getNumeroContaBancaria();
		contaPj.setContaPJ(contaPJ);
		return ;
	}
	
	
}
