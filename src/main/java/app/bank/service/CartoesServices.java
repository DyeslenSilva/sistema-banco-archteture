package app.bank.service;

import org.springframework.stereotype.Service;

import app.bank.model.Cartoes;
import app.bank.model.ClientePF;
import app.bank.model.Credito;
import app.bank.model.Debito;
import app.bank.model.Fatura;
import app.bank.repo.CartoesInteface;
import app.bank.serviceconfig.ConfigCartao;

@Service
public class CartoesServices implements CartoesInteface{

	//private ConfigCartao configCartao;
	

	@Override
	public void gerarCartaoDeDebito(int min, int max, String nome) {
		ConfigCartao.gerarNumeroDoCartao(min, max);
		ConfigCartao.adicionarNome(nome);
	}

	

	@Override
	public void gerarCartaoDeCredito(int min, int max, String nome) {
		ConfigCartao.gerarNumeroDoCartao(min, max);
		ConfigCartao.adicionarNome(nome);
	}


	@Override
	public void gerarFaturaDeCredito() {
		Fatura.gerarFatura(Fatura.getNCartao(),Fatura.getValorFatura(), Fatura.getDataVencimento(), 
					Fatura.getDescricaoCompra(), Fatura.getNParcela());
	}

	@Override
	public void consultaSaldo(ClientePF clientePF) {
		
	}

	@Override
	public void consultaLimite(Cartoes cartoes, Credito credito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultaFatura(Cartoes cartoes, Credito credito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(Cartoes cartoes, Debito debito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bloquearCartaoDeDebito(Cartoes cartoes, Debito debito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bloquearCartaoDeCredito(Cartoes cartoes, Credito credito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarCartaoDeDebito(Cartoes cartoes, Debito debito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarCartaoDeCredito(Cartoes cartoes, Credito credito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarPagamentoDeFatura(Cartoes cartoes, Credito credito) {
		// TODO Auto-generated method stub
		
	}






}
