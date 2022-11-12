package app.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Credito extends Cartoes{

	@Getter @Setter
	private static Cartoes cartoes;
	
	public static double consultaLimitePF(Cartoes cartao, int senha) {
		double limite = Cartoes.getLimiteCredito();
		if(cartoes.setNCartao(Cartoes.getNCartao()) && cartoes.setSenha(senha)) {
			return cartoes.setLimiteCredito(limite);
		}else {
			return limite;
		}
	}
	
	public static double consultaLimitePJ(Cartoes cartao , int senha) {
		double limite = Cartoes.getLimiteCredito();
		if(cartoes.setNCartao(Cartoes.getNCartao())&& cartoes.setSenha(senha)) {
			return cartoes.setLimiteCredito(limite);
		}else {
			return limite;
		}
	}

	public boolean setNCartao(int[] nCartao) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
