package app.bank.model;

public class Transacoes {
	
	
	private ContaBancaria bancaria;
	private PIX pix;
	
	
	public void deposito(int conta, double valor) {
		bancaria.nConta(conta);
		bancaria.valorDeposito(valor);
	}
	
	public void transferenciaTED(int contaCliente, int contaDestino, double valor, int tempo) {
		bancaria.nConta(contaCliente);
		bancaria.contaDestino(contaDestino);
		bancaria.valorTranferenciaTED(valor);
		bancaria.time(tempo);
	}
	
	public void transferenciaDOC(int contaCliente, int contaDestino, double valor) {
		bancaria.nConta(contaCliente);
		bancaria.contaDestino(contaDestino);
		bancaria.valorTranferenciaDOC(valor);
	}
	
	public void pix(TipoChave chave, double valor) {
		pix.realizarTransacao(chave, valor);
	}
	
}
