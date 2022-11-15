package app.bank.service;

import org.springframework.stereotype.Service;

import app.bank.model.CaixaEletronico;
import app.bank.model.Cartoes;
import app.bank.model.ClientePF;
import app.bank.model.ClientePJ;
import app.bank.model.ContaPF;
import app.bank.model.ContaPJ;
import app.bank.model.Credito;
import app.bank.model.Debito;
import app.bank.model.Fatura;
import app.bank.repo.CartoesInteface;
import app.bank.serviceconfig.ConfigCartao;

@Service
public class CartoesServices implements CartoesInteface{

	//private ConfigCartao configCartao;
	private Debito debito;
	private Credito credito;
	private CaixaEletronico caixaEletronico;
	private Cartoes cartoes;
	private ContaPF contaPF;
	private ContaPJ contaPJ;
	
	private Fatura getFatura() {
		Fatura fatura = new Fatura();
		return fatura;
	}
	
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
	public double consultaSaldoPF(ClientePF clientePF, int senha) {
		double saldoPF = Debito.consultaSaldoPF(clientePF.setCpf(clientePF.getCpf()), 
							contaPF.setSenha(contaPF.getSenha()));
		return saldoPF;
	}

	
	@Override
	public double consultaSaldoPJ(ClientePJ clientePJ, int senha) {
		double saldoPJ =	Debito.consultaSaldoPJ(clientePJ.setCNPJ(clientePJ.getCNPJ()), 
					contaPJ.setSenha(contaPJ.getSenha()));
		return saldoPJ;
	}

	public double consultaLimite(Cartoes cartoes, int senha) {
		double limitePF =	Credito.consultaLimiteCartaoPF(Cartoes.getNCartao(), senha);
		return limitePF;
	}

		
	@Override
	public Fatura gerarFaturaDeCredito(Fatura fatura) {
		Fatura fat =
		Fatura.gerarFatura(Fatura.getNCartao(), Fatura.getValorFatura(), Fatura.getDataVencimento(),
					Fatura.getDescricaoCompra(), Fatura.getNParcela());
		return fat;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public Fatura consultaFaturaDeCredito(Fatura nFatura, int senha) {
		Fatura fatura = getFatura();
				fatura.consultaFatura(fatura.setNCartao(nFatura.getNCartao()),
								fatura.getSenhaFatura(senha));
		return fatura;
	}

	
	@SuppressWarnings("static-access")
	@Override
	public void sacar(int []nCartao,double valorDoSaque) {
		caixaEletronico.saque(cartoes.setNCartao(nCartao),
							debito.setValorDoSaque(valorDoSaque));
	}

	@SuppressWarnings("static-access")
	@Override
	public void bloquearCartao(int []nCartao, int senha) {
		cartoes.bloquearCartao(Cartoes.setNCartao(cartoes.getNCartao()), 
							cartoes.setSenha(cartoes.getSenha()));
	}



	@SuppressWarnings("static-access")
	@Override
	public void cancelarCartao(int []nCartao, int senha) {
		cartoes.cancelarCartao(Cartoes.setNCartao(cartoes.getNCartao()), 
						Cartoes.setSenha(cartoes.getSenha()));
	}


	@SuppressWarnings("static-access")
	@Override
	public void realizarPagamentoDeFatura(int[] nCartao, double valorFatura, int senha) {
		Fatura fatura = getFatura();
		//fatura.pagamentoFatura(nCartao, valorFatura, senha);
		fatura.pagamentoFatura(cartoes.setNCartao(cartoes.getNCartao()), 
					cartoes.setValorFatura(fatura.getValorFatura()), 
					cartoes.setSenha(fatura.getSenhaFatura()));
	}
}