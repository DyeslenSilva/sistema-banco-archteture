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
	//public void consultaFatura(Cartoes cartoes);
	//	public void sacar(Cartoes cartoes, Debito debito);
	//public void bloquearCartaoDeDebito(Cartoes cartoes, Debito debito) ;
	//public void bloquearCartaoDeCredito(Cartoes cartoes, Credito credito);
	//public void cancelarCartaoDeDebito(Cartoes cartoes, Debito debito);
	//public void cancelarCartaoDeCredito(Cartoes cartoes, Credito credito);
	public void realizarPagamentoDeFatura(int [] nCartao,double valorFatura, int senha);
	public void gerarCartaoDeDebito(int min, int max, String nome);
	public Fatura gerarFaturaDeCredito(Fatura fatura);
	public Fatura consultaFaturaDeCredito(Fatura nFatura, int senha);
	double consultaSaldoPF(ClientePF clientePF, int senha);
	double consultaSaldoPJ(ClientePJ clientePJ, int senha);
//	void consultaLimitePJ(ClientePJ clientePJ, int senha);
//	void consultaLimitePF(Cartoes cartoes, int senha);
	//void sacar(double valorDoSaque);
	void sacar(int[] nCartao, double valorDoSaque);
	//void bloquearCartaoDeDebito(int[] nCartao, int senha);
	void bloquearCartao(int[] nCartao, int senha);
	void cancelarCartao(int[] nCartao, int senha);
	//void consultaLimite(Cartoes cartoes, int senha);
	//void consultaLimitePF(Cartoes cartoes, int senha);
	//void consultaLimitePJ(Cartoes cartoes, int senha);
	double consultaLimite(Cartoes cartoes, int senha);
	//void vincularCDebitoAConta();
	//void vincularCCreditoAConta();
	void vincularCDebitoAConta(int[] nCarto, int nConta);
	void vincularCCreditoAConta(int[] nCartao, int nConta);
	
}
