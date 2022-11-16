package app.bank.model;

import lombok.Getter;
import lombok.Setter;


public class Debito extends Cartoes {
	
	@Getter 	@Setter
	private static ContaPF contaPF;
	
	@Getter @Setter
	private static ContaPJ contaPJ;

	private static int senha;
	
	@Getter @Setter
	private double valorDoSaque;
	
	private Cartoes cartoes;
	
	
	public Debito getDebitoC(Debito debito) {
		Debito debitoC = getDebito();
		return debitoC.getDebito();
	}
	
	
	private Debito getDebito() {
		return this.getDebito();
	}


	private static ClientePF getClientePF() {
		ClientePF clientePF = new ClientePF();
		return clientePF;
	}

	
	private static ClientePJ getClientePJ() {
		ClientePJ clientePJ = new ClientePJ(getClientePJ());
		return clientePJ;
	}

	public static double consultaSaldoPF(ClientePF clientePF, int senha) {
		double saldo = Cartoes.getSaldoDebito();
		if(contaPF.setClientePF(clientePF.getCpf())&& contaPF.setSenha(senha)) {
			return contaPF.setSaldo(saldo);
		}
		return saldo;
	}
	
	public static double consultaSaldoPJ(ClientePJ clientePJ, int senha) {
		double saldo = Cartoes.getSaldoDebito();
		if(contaPJ.setClientePJ(clientePJ.getCNPJ())&& contaPJ.setSenha(senha)) {
			return contaPJ.setSaldo(saldo);
		}else {
			return saldo;
		}
	}

	public static double consultaSaldoPF(String cpf, int senha) {
		ClientePF pf =contaPF.getClientePF();
		double saldo = Cartoes.getSaldoDebito();
		if( Boolean.parseBoolean(contaPF.setClientePFf(pf.setCpf(cpf))) && contaPF.setSenha(senha)) {
			return contaPF.setSaldo(saldo);
		}else {
			return saldo;
		}
	}
	
	public static double consultaSaldoPJ(String cnpj, int senha) {
		ClientePJ pj = contaPJ.getClientePJ();
		double saldo = Cartoes.getSaldoDebito();
		if(Boolean.parseBoolean(contaPJ.setClientePJ(pj.setCNPJ(cnpj)))&&contaPJ.setSenha(senha)) {
				return contaPJ.setSaldo(saldo);
		}else {
			return saldo;
		}
	}	
	
	public	Object setValorDoSaque(double valorDoSaque) {
		Object valorSaque = valorSaque();
			if(valorSaque.equals(valorDoSaque)) {
				return valorSaque;
			}
			return valorSaque;
	}

	private Object valorSaque() {
		Object valorSaque =new Object();
		return valorSaque;
	}

	public static double consultaSaldoPF(String setCpf, boolean setSenha) {
		double saldo = Cartoes.getSaldoDebito();
		ClientePF clientePF = getClientePF();
		if(contaPF.setClientePF(clientePF.getCpf())&& contaPF.setSenha(senha)) {
			return contaPF.setSaldo(saldo);
		}
		return saldo;
	}
	
	public static double consultaSaldoPJ(boolean setCNPJ, boolean setSenha) {
		double saldo = Cartoes.getSaldoDebito();
		ClientePJ clientePJ = getClientePJ();
		if(contaPJ.setClientePJ(clientePJ .getCNPJ())&& contaPJ.setSenha(senha)) {
			return contaPJ.setSaldo(saldo);
		}else {
			return saldo;
		}	
	}
	
	@SuppressWarnings("static-access")
	public void vincularCartaoConta(int [] nCartao, int nConta) {
		if(cartoes.setNCartao(nCartao) && contaPF.setNumeroConta(nConta)) {
			
		}
	}
	


	
}
