package app.bank.repo;

import app.bank.model.Cartoes;
import app.bank.model.Credito;
import app.bank.model.Debito;

public interface CartoesInteface {

	public void gerarCartaoDeDebito();
	public void gerarCartaoDeCredito();
	public void gerarFaturaDeCredito(Cartoes cartoes, Credito credito);
	public void consultaSaldo(Cartoes cartoes, Debito debito);
	public void consultaLimite(Cartoes cartoes, Credito credito);
	public void consultaFatura(Cartoes cartoes, Credito credito);
}
