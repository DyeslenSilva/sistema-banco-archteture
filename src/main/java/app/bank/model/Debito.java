package app.bank.model;

import lombok.Getter;
import lombok.Setter;


public class Debito extends Cartoes {
	
	@Getter 	@Setter
	private static ContaPF contaPF;
	
	@Getter @Setter
	private static ContaPJ contaPJ;
	

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
	
}
