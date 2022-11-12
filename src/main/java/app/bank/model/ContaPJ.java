package app.bank.model;

import lombok.Data;

@Data
public class ContaPJ extends ContaBancaria{
	private ClientePJ clientePJ;
	
	private boolean ativado, desativado;
	private int senha;

	public boolean setClientePJ(String cnpj) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public double setSaldo(double saldo) {
		return saldo;
	}
	
	public boolean setSenha(int senha) {
		return true;
	}
}
