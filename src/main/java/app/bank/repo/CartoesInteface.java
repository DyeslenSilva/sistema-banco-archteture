package app.bank.repo;

import app.bank.model.Cartoes;
import app.bank.model.ClientePF;
import app.bank.model.ClientePJ;
import app.bank.model.Credito;
import app.bank.model.Debito;
import app.bank.model.Fatura;

public interface CartoesInteface {

	public void gerarCartaoDeCredito(int min, int max, String nome);
	//public void gerarFaturaDeCredito();
	//public void consultaSaldo(ClientePF clientePF);
	//public void consultaLimite(Cartoes cartoes, Credito credito);
	public void consultaFatura(Cartoes cartoes);
	public void sacar(Cartoes cartoes, Debito debito);
	public void bloquearCartaoDeDebito(Cartoes cartoes, Debito debito) ;
	public void bloquearCartaoDeCredito(Cartoes cartoes, Credito credito);
	public void cancelarCartaoDeDebito(Cartoes cartoes, Debito debito);
	public void cancelarCartaoDeCredito(Cartoes cartoes, Credito credito);
	public void realizarPagamentoDeFatura(Cartoes cartoes, Credito credito);
	public void gerarCartaoDeDebito(int min, int max, String nome);
	void gerarFaturaDeCredito();
	void consultaSaldoPF(ClientePF clientePF, int senha);
	void consultaSaldoPJ(ClientePJ clientePJ, int senha);
	void consultaLimite(ClientePJ clientePJ, int senha);
	void consultaLimite(ClientePF clientePF, int senha);
	void consultaLimite(Cartoes cartoes, int senha);
}
