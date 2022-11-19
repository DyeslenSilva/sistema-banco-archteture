package app.bank.service;

import java.util.Date;

import app.bank.enumeratiom.TipoChave;
import app.bank.model.PIX;
import app.bank.model.Transacoes;

public class TransacoesService {

		private Transacoes transacoes;
		private PIX pix;
			
			public void realizarDeposito(int conta, double valor) {
				transacoes.deposito(conta, valor);
			}
	
			public void realizarTransfereciaDOC(int contaCliente, int contaDestino, double valor) {
				transacoes.transferenciaDOC(contaCliente, contaDestino, valor);
			}
			
			public void realizarTransferenciaTED(int contaCliente, int contaDestino, double valor, int tempo) {
				transacoes.transferenciaTED(contaCliente, contaDestino, valor, tempo);
			}
			

			public void realizarPIX(TipoChave[] tipoChave, String chave, Double valor) {
				transacoes.pix(tipoChave, chave, valor);
				
			}

			public void pixProgramado(TipoChave[] tipoChave, String chave, Double valor, Date data) {
				pix.pixProgramado(tipoChave, chave, valor, data);
			}
}
