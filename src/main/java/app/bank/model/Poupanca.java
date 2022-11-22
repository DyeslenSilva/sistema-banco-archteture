package app.bank.model;

import lombok.Data;

@Data
public class Poupanca {
	
		private double capital;
		private double taxaDeJuros;
		private int tempo;
		private double montante;
		private double taxaCDI;
		private double taxaCDB;
		
		
		public double calculaJuros(double capital, double taxaDeJuros, int tempo) {
			montante = capital *Math.pow(1+taxaDeJuros/100, tempo);
			return montante;
		}
		
		
}
