package app.bank.model;

import lombok.Data;

@Data
public class CaixaEletronico {

	private NotasDinheiro dinheiro;
	
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
		
	}
	
	
	public boolean valorDoSaque(double valorSaque) {
		if(valorSaque > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public NotasDinheiro saque(double valorSaque) {
		NotasDinheiro dinheirosNota = getNotasDinheiro();
		if(dinheirosNota.notasNoCaixa(dinheirosNota));
	}
}
