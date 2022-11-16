package app.bank.model;

import lombok.Data;

@Data
public class ContaCliente {

	private ContaPF contapf;
	private ContaPJ contaPJ;
	private Cartoes cartoes;
	private Debito debito;
	private Credito credito;
	private Fatura fatura;
	private Transacoes transacoes;
	
	
	@SuppressWarnings("static-access")
	public void vinculoPFDebito(ContaPF conta, Debito debito) {
		contapf.contaPF(conta.getNumeroContaBancaria())
			.debito(debito.getNCartao());
	}
	
	@SuppressWarnings("static-access")
	public void vinculoPJDebito(ContaPJ contapj, Debito debito) {
		contaPJ.contaPJ(contapj.getNumeroContaBancaria())
			.debito(debito.getNCartao());
	}
	
	@SuppressWarnings("static-access")
	public void vinculoPFCredito(ContaPF contaPF, Credito credit) {
		contapf.contaPF(contaPF.getNumeroContaBancaria())
			.credito(credit.getNCartao());
	}

	@SuppressWarnings("static-access")
	public void vinculoPJCredito(ContaPJ contaPJ, Credito credito) {
		contaPJ.contaPJ(this.contaPJ.getNumeroContaBancaria())
				.credito(credito.getNCartao());
			
	}
}
