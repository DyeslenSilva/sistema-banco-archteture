package app.bank.model;

import lombok.Data;

@Data
public class Investimentos {

	private double valorInvestimentoS;
	private static double jurosDeInvestimento =0.05;
	private Poupanca poupanca;
	
	
	public double taxaCDI(double taxaDeJuros) {
		return (taxaDeJuros)/(110.0/100);
	}
	
	public double poupanca(double capital, double taxaDeJuros,int tempo) {
		return poupanca.calculaJuros(capital, taxaDeJuros, tempo) * taxaCDI(taxaDeJuros);
	}
	
		
	public double taxaCDB(double taxaCDI, double taxaCDB) {
		return (taxaCDI/100)*(taxaCDB/100);
	}
	
	public double poupancaCDB(double capital, double taxaDejuros, int tempo) {
		double taxaCDI = poupanca.getTaxaCDI()/100;
		double taxaCDB = poupanca.getTaxaCDB()/100;
		return poupanca.calculaJuros(capital, taxaDejuros, tempo)*taxaCDB(taxaCDI, taxaCDB);
	}
	

	
}
