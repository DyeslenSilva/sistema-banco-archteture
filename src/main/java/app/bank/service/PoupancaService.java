package app.bank.service;

import app.bank.model.Investimentos;
import app.bank.model.Poupanca;

public class PoupancaService {
	
	private Poupanca poupanca;
	private Investimentos investimentos;
	
	public double cdb(double capital, double taxa, int tempo) {
		return investimentos.poupancaCDB(capital, taxa, tempo);
	}
	
	public double cdi(double capital, double taxa, int temp) {
		return investimentos.taxaCDI(taxa)*
					investimentos.poupanca(capital, taxa, temp);
	}
}
