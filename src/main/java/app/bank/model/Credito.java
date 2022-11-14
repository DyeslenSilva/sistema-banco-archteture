package app.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Credito extends Cartoes{

	@Getter @Setter
	private static Cartoes cartoes;
	
	@Getter @Setter
	private static ContaPF contaPF;
	
	@Getter @Setter
	private ContaPJ contaPJ;
	
	public static double consultaLimitePF(int[] is, int senha) {
		double limite = Cartoes.getLimiteCredito();
		if(Cartoes.setNCartao(Cartoes.getNCartao()) && Cartoes.setSenha(senha)) {
			return cartoes.setLimiteCredito(limite);
		}else {
			return limite;
		}
	}
	
	
	public static double consultaLimiteCartaoPF(int[]nCartao, int senha){
		double limite = Cartoes.getLimiteCredito();
		//ClientePF pf =contaPF.getClientePF();
		if((Cartoes.setNCartao(Cartoes.setNCartao(nCartao))   && Cartoes.setSenha(senha))) {
		return cartoes.setLimiteCredito(limite);
	}else {
		return limite;
	}}
	

	public static double consultaLimitePJ(Cartoes cartao , int senha) {
		double limite = Cartoes.getLimiteCredito();
		if(Cartoes.setNCartao(Cartoes.getNCartao())&& Cartoes.setSenha(senha)) {
			return cartoes.setLimiteCredito(limite);
		}else {
			return limite;
		}
	}
	
	public static double consultaLimiteCartaoPJ(int[]nCartao, int senha) {
		double limite = Cartoes.getLimiteCredito();
		if(Cartoes.setNCartao(Cartoes.setNCartao(nCartao))&& Cartoes.setSenha(senha)) {
			return cartoes.setLimiteCredito(limite);
		}else {
			return limite;
		}
	}


}
