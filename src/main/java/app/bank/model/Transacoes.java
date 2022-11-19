package app.bank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.bank.enumeratiom.TipoChave;

public class Transacoes {
	
	
	private ContaBancaria bancaria;
	private PIX pix;
	private List<Transacoes> transacoes = new ArrayList<>();
	
	
	@SuppressWarnings("unchecked")
	public Transacoes deposito(int conta, double valor) {
		transacoes = (List<Transacoes>) bancaria.nConta(conta);
		transacoes = 	bancaria.valorDeposito(valor);
		return transacoes.get(conta);
	}
	
	@SuppressWarnings("unchecked")
	public List<Transacoes> transferenciaTED(int contaCliente, int contaDestino, double valor, int tempo) {
		List<Transacoes> transferenciaTED = new ArrayList<>();
		
		transferenciaTED =  (List<Transacoes>) bancaria.nConta(contaCliente);
		transferenciaTED = 	bancaria.contaDestino(contaDestino);
		transferenciaTED =  bancaria.valorTranferenciaTED(valor);
		transferenciaTED =   bancaria.time(tempo);
		return transferenciaTED;
	}
	
	public List<Transacoes> transferenciaDOC(int contaCliente, int contaDestino, double valor) {
		List<Transacoes> transfereciaDOC = new ArrayList<>();		
		transfereciaDOC =  bancaria.nConta(contaCliente);
		transfereciaDOC =  bancaria.contaDestino(contaDestino);
		transfereciaDOC =  bancaria.valorTranferenciaDOC(valor);
		return transfereciaDOC;
	}
	
	public List<Transacoes> pix(TipoChave[] chave, String valorChave,double valor) {
		List<Transacoes> transacaoPIX = new ArrayList<>();
		transacaoPIX = pix.realizarTransacao(chave,valorChave,valor);
		return transacaoPIX;
	}

	
	public List<Transacoes> pixTemporal(TipoChave[] chave, String valorChave, double valor, Date data){
		List<Transacoes> pixTemporal = new ArrayList<>();
		pixTemporal = pix.pixProgramado(chave, valorChave, valor, data);
		return pixTemporal;
 	}
	
	public List<Transacoes> vizualizarTransacoes(){
		List<Transacoes> transacoes = new ArrayList<>();
		int nConta= getNConta();
		transacoes.add(deposito(0, 0));
		
	}

	private int getNConta() {
		return 0;
	}
	
	
}
