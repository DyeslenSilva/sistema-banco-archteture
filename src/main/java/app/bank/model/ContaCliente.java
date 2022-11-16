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
}
