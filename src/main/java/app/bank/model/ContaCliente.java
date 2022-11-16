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

	
	public void vinculoPFDebito(int setNumeroContaBanc, boolean setNCartao) {
		contapf.contaPF(contapf.setNumeroContaBanc(setNumeroContaBanc))
				.debito(cartoes.setNCartao(BooleanToInt.boolToInt(setNCartao)));
	}

	
	public void vinculoPFCredito(int setNumeroContaBanc, boolean setNCartao) {
			contapf.contaPF(contapf.setNumeroContaBanc(setNumeroContaBanc))
				.credito(cartoes.setNCartao(BooleanToInt.boolToInt(setNCartao)));
	}

	public void vinculoPJDebito(int setNumeroContaBanc, boolean setNCartao) {
		contaPJ.contaPJ(contaPJ.setNumeroContaBanc(setNumeroContaBanc))
				.debito(cartoes.setNCartao(BooleanToInt.boolToInt(setNCartao)));
	}

	public void vinculoPJCredito(int setNumeroContaBanc, boolean setNCartao) {
		contaPJ.contaPJ(contaPJ.setNumeroContaBanc(setNumeroContaBanc))
				.credito(cartoes.setNCartao(BooleanToInt.boolToInt(setNCartao)));
		
	}
	
	
}


class BooleanToInt{
	
	public static int boolToInt(Boolean bool) {
		return bool.compareTo(bool);
	}
}