package app.bank.model;

import org.springframework.web.client.HttpClientErrorException.NotAcceptable;

import lombok.Data;

@Data
public class NotasDinheiro {

	private double n2reais;
	private double n5reais;
	private double n10reais;
	private double n20reais;
	private double n50reais;
	private double n100reais;
	private double n200reais;
	double notas;
	
	public double notas() {
		return notas;
	}


	
	public  double notasNoCaixa(double valorSaque) {
		double notasDeDinheiro = notas();
		if(valorSaque >=0) {
			return notasDeDinheiro;
		}else {
			return 0;
		}
	}
	
	public  boolean notasNoCaixaBool(NotasDinheiro notas) {
		//double notasDeDinheiro = notas();
		if(notas != null) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
}
