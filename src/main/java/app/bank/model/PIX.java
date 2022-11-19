package app.bank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.bank.enumeratiom.TipoChave;
import lombok.Data;

@Data
public class PIX {

	private ClientePF chavePIXpf;
	private ClientePJ chavePIXpj;
	private String chavePIX;
	private double valorTransacao;
	
	public void cadastroChavePixRG(String rg) {
		chavePIX = chavePIXpf.setRG(rg);
	}

	public void cadastroChavePIXcpf(String cpf) {
		chavePIX = 	chavePIXpf.setCPF(cpf);
	}
	
	public void cadastroChavePIXtelefone(String telefone) {
		chavePIX = 	chavePIXpf.setTelefone(telefone);
	}
	
	public void cadastroChavePIXcnpj(String cnpj) {
		chavePIX =  chavePIXpj.setCNPJj(cnpj);
	}
	
	
	
	private List<Transacoes> dataTransferencia(Date dataTransferencia) {
		return this.dataTransferencia(dataTransferencia);
	}
	
	public List<Transacoes> valorTransacao(double valorTransacao) {
		List<Transacoes> valorTransacoes = new ArrayList<>();//
			return valorTransacoes;
	}
	
	
	
	public List<Transacoes> pixProgramado(TipoChave[] tipoChave,String valorChave, double valor, Date dataDeTransferencia) {
		List<Transacoes> pixProgramado = new ArrayList<>();
		
		pixProgramado = 	this.valorTransacao(valor);
		pixProgramado =	this.tipoChave(tipoChave);
		
		pixProgramado =	this.dataTransferencia(dataDeTransferencia);
		return pixProgramado;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private List<Transacoes> tipoChave(TipoChave[] tipoChave) {
			List<Transacoes> chave  = new ArrayList<>();
			
			TipoChave.CNPJ.compareTo(TipoChave.CNPJ);
			TipoChave.CPF.compareTo(TipoChave.CPF);
			TipoChave.telefone.compareTo(TipoChave.telefone);
			TipoChave.RG.compareTo(TipoChave.RG);
			chave.contains(tipoChave);
			return chave;
	}

	public List<Transacoes> realizarTransacao(TipoChave[] tipoChave,String chave, double valor) {
		List<Transacoes> pix = new ArrayList<>();
		pix =	this.setChavePIX(chave);
		pix =	this.valorTransacao(valor);
		pix =	this.tipoChave(tipoChave);
		return pix;
	}
	
	public List<Transacoes> setChavePIX(String chavePix){
		List<Transacoes> chave =new  ArrayList<>();
		return chave;
	}
	
	
	public void valorChave(String valorChave) {
		this.valorChave(valorChave);
	}
	
	
	
}

