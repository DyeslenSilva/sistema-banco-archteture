package app.bank.model;

import lombok.Data;

@Data
public class CaixaEletronico {

	private NotasDinheiro dinheiro;
	private ContaBancaria contaBancaria;
	
	public NotasDinheiro getNotasDinheiro() {
		NotasDinheiro notasDinheiro = new NotasDinheiro();
		return notasDinheiro;
	}
	
	
	
	public boolean verificaSeExisteNota(NotasDinheiro notasDinheiro) {
		if(dinheiro.notasNoCaixaBool(notasDinheiro)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean autorizaSaque(double valorSaque) {
		NotasDinheiro notasDinheiro = getNotasDinheiro();
		ContaBancaria contaBancaria = getContaBancaria();
		if(notasDinheiro.notasNoCaixa(valorSaque)>= valorDoSaque(valorSaque) && 
						contaBancaria.verificaSaldo(contaBancaria.getNumeroContaBancaria()	)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public double valorDoSaque(double valorSaque) {
		if(valorSaque > 0) {
			return valorSaque;
		}else {
			return 0;
		}
	}
	
	
	public NotasDinheiro saque(int[] nCartao, double valorSaque) {
		NotasDinheiro dinheirosNota = getNotasDinheiro();
		Cartoes cartoes = getCartao(nCartao);
		if(autorizaSaque(valorSaque) && cartaoCliente(cartoes)) {
			return dinheirosNota;
		}else {
			return null;
		}
	}



	private static boolean cartaoCliente(Cartoes cartoes) {
		if(Cartoes.setNCartao(true)) {
			return true;
		}else {
		return false;
	}
}

	private Cartoes getCartao(int[] nCartao) {
		Cartoes  cartoes = getCartoes();
		if(nCartao.length == nCartao.length) {
			return cartoes;
		}
		return getCartoes();
		
	}

	private Cartoes getCartoes() {
		Cartoes cartoes = new Cartoes();
		return cartoes;
	}



	public void saque(boolean setNCartao, Object setValorDoSaque) {
		
	}
	
	
	
}
