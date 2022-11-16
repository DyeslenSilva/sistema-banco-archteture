package app.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clientePJ")
public class ClientePJ {

	public ClientePJ(ClientePJ clientePJ) {
		// TODO Auto-generated constructor stub
	}

	@Id
	private String CNPJ;
	private String razaoSocial, proprietarioResponsavel, telefoneResponsavel;
	private String celular;
	private int quantidadeDeEmpregados,quantidadeDeFiliais;
	private String endereco,bairro, municipio, estado;
	private int n;
	
	private boolean ativado, desativado;
	
	
	
	public boolean setCNPJ(String cnpj) {
		return true;
	}
	
	public ClientePJ cnpj(String cnpj) {
		ClientePJ clientePJ = ConvertePJ.transfPJ(cnpj);
		return clientePJ;
	}

	public Cartoes nConta(int nConta) {
		Cartoes cartoes = getConta(nConta);
		return cartoes;
	}

	private Cartoes getConta(int nConta) {
		Cartoes cartoes = new Cartoes();
		return cartoes;
	}
	
	
}

class ConvertePJ{
	public static ClientePJ transfPJ(Object cliente) {
		if(cliente != null) {
			return (ClientePJ) cliente;
		}else {
			return null;
		}
}
}
