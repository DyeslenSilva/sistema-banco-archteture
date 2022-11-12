package app.bank.model;

import app.bank.serviceconfig.ConfigCartao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Cartoes {
	
	private ConfigCartao configCartao;
	
	@Getter @Setter
	private static double saldoDebito;
	
	@Getter @Setter
	private static double limiteCredito;
	
	static @Getter @Setter
	private int[] nCartao;
	
	private int senha;
	
	public boolean setSenha(int senha) {
		return true;
	}

	public double setLimiteCredito(double limite) {
		return limite;
	}

	public boolean setNCartao(int[] nCartao) {
		return true;
	}
}
