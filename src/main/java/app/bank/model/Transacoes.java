package app.bank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.bank.enumeratiom.TipoChave;

public class Transacoes {
	
	
	private ContaBancaria bancaria;
	private PIX pix;
	private List<Transacoes> transacoes = new ArrayList<>();
	
	
	public Transacoes deposito(int conta, double valor) {
		transacoes = (List<Transacoes>) bancaria.nConta(conta);
		transacoes = 	bancaria.valorDeposito(valor);
		return transacoes.get(conta);
	}
	
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
	
	@SuppressWarnings("unchecked")
	public List<Transacoes> vizualizarTransacoes(){
		List<Transacoes> transacoes = new ArrayList<>();
		int nConta= getNConta();
		int nContaDestino = getNContaDestino();
		double valorDeposito = getValorDeposito();
		int tempo = getTempo();
		TipoChave[] tipoChave = getTipoChave();
		String chave = getChave();
		Date data = getDataPix();
		transacoes.add(deposito(nConta, valorDeposito));
		transacoes.add((Transacoes) transferenciaDOC(nConta, nContaDestino, valorDeposito));
		transacoes.add((Transacoes) transferenciaTED(nConta, nContaDestino, valorDeposito, tempo));
		transacoes.add((Transacoes) pix(tipoChave, chave, valorDeposito));
		transacoes.add((Transacoes) pixTemporal(tipoChave, chave, valorDeposito, data));
		for(Transacoes transacao : transacoes) {
			return (List<Transacoes>) transacao;
		}
		return transacoes;
	}
	
	private Date getDataPix() {
		return getDataPix();
	}

	private String getChave() {
		return getChave();
	}

	private TipoChave[] getTipoChave() {
		return getTipoChave();
	}

	private int getTempo() {
		return getTempo();
	}

	private int getNContaDestino() {
		return getNContaDestino();
	}

	private double getValorDeposito() {
		return getValorDeposito();
	}

	private int getNConta() {
		return getNConta();
	}
	
	
}
