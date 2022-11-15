package app.bank.model;

import app.bank.enumeratiom.BloqueioDesbloqueioCancel;
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
	
	@Getter @Setter	
	private int senha;
	
	public static boolean setSenha(int senha) {
		return true;
	}

	public double setLimiteCredito(double limite) {
		return limite;
	}

	public static boolean setNCartao(int[] nCartao) {
		return true;
	}

	public static boolean setNCartao(boolean setNCartao) {
		return false;
	}
	
	
	public void setCartao(int[] nCartao, int senha) {
		Cartoes.setNCartao(nCartao);	
		Cartoes.setSenha(senha);
	}
	
	public void bloquearCartao(int[] nCartao, int senha) {
		if (BloqueioDesbloqueioCancel.Aplicativo != null) {
				this.setCartao(setNCartao(nCartao),setSenha(senha));
		}else if (BloqueioDesbloqueioCancel.CaixaEletronico != null) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}else if(BloqueioDesbloqueioCancel.Guiche != null) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}
	}
	
	public void desbloquearCartao(int[] nCartao, int senha) {
		if(BloqueioDesbloqueioCancel.Aplicativo != null) {
			this.setCartao(setNCartao(nCartao),setSenha(senha));
		}else if(BloqueioDesbloqueioCancel.CaixaEletronico !=null) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}else if(BloqueioDesbloqueioCancel.Guiche !=null) {
			this.setCartao(setNCartao(nCartao),setSenha(senha));
		}
	}

	public void cancelarCartao(int[] nCartao, int senha) {
		if(BloqueioDesbloqueioCancel.Aplicativo != null ) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}else if(BloqueioDesbloqueioCancel.CaixaEletronico != null) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}else if(BloqueioDesbloqueioCancel.Guiche != null) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}
	}
	
	private void setCartao(boolean setNCartao, boolean setSenha) {
		Cartoes.setNCartao(setNCartao);
		Cartoes.setSenha(senha);
	}

	public void bloquearCartao(boolean setNCartao, boolean setSenha) {
		if (BloqueioDesbloqueioCancel.Aplicativo != null) {
			this.setCartao(setNCartao(nCartao),setSenha(senha));
	}else if (BloqueioDesbloqueioCancel.CaixaEletronico != null) {
		this.setCartao(setNCartao(nCartao), setSenha(senha));
	}else if(BloqueioDesbloqueioCancel.Guiche != null) {
		this.setCartao(setNCartao(nCartao), setSenha(senha));
	}}

	public void cancelarCartao(boolean setNCartao, boolean setSenha) {
		if(BloqueioDesbloqueioCancel.Aplicativo != null ) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}else if(BloqueioDesbloqueioCancel.CaixaEletronico != null) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}else if(BloqueioDesbloqueioCancel.Guiche != null) {
			this.setCartao(setNCartao(nCartao), setSenha(senha));
		}
		
	}

	public Object setValorFatura(double valorFatura) {
		// TODO Auto-generated method stub
		return null;
	}

}		


