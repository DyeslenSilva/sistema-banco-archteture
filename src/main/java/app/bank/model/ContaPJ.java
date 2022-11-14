package app.bank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContaPJ extends ContaBancaria{
	private ClientePJ clientePJ;
	
	private boolean ativado, desativado;
	private int senha;

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
}
