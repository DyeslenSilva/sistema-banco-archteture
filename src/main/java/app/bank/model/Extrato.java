package app.bank.model;

public class Extrato {

	private ContaCorrente contaCorrente;
	
	public void gerarExtrato(int nCartao, int senha) {
		contaCorrente.extrato(nCartao, senha);
	}
}
