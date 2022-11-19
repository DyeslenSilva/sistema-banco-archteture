package app.bank.model;

import lombok.Data;

@Data
public class PIX {

	private ClientePF chavePIXpf;
	private ClientePJ chavePIXpj;
	private String chavePIX;
	private double valorTransacao;
	
	public void cadastroChavePixRG(String rg) {
		chavePIX = chavePIXpf.setRG(rg);
	}

	public void cadastroChavePIXcpf(String cpf) {
		chavePIX = 	chavePIXpf.setCPF(cpf);
	}
	
	public void cadastroChavePIXtelefone(String telefone) {
		chavePIX = 	chavePIXpf.setTelefone(telefone);
	}
	
	public void cadastroChavePIXcnpj(String cnpj) {
		chavePIX =  chavePIXpj.setCNPJj(cnpj);
	}
	
	
	public double valorTransacao(double valorTransacao) {
			return this.valorTransacao;
	}
	
	public void realizarTransacao(TipoChave chave, double valor) {
		this.valorTransacao(valor);
		this.tipoChave(chave);
	}
	
	private void tipoChave(TipoChave tipoChave) {
			TipoChave.CNPJ.compareTo(TipoChave.CNPJ);
			TipoChave.CPF.compareTo(TipoChave.CPF);
			TipoChave.telefone.compareTo(TipoChave.telefone);
			TipoChave.RG.compareTo(TipoChave.RG);
	}
	
}




enum TipoChave{
	RG,
	CPF,
	telefone,
	CNPJ
}