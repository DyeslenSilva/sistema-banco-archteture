package app.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clientePJ")
public class ClientePJ {

	@Id
	private String CNPJ;
	private String razaoSocial, proprietarioResponsavel, telefoneResponsavel;
	private String celular;
	private int quantidadeDeEmpregados,quantidadeDeFiliais;
	private String endereco,bairro, municipio, estado;
	private int n;
	
	private boolean ativado, desativado;
}
