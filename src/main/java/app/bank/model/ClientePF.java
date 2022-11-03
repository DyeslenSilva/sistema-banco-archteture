package app.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "clientePF")
@AllArgsConstructor
@NoArgsConstructor
public class ClientePF {

	@Id
	private String rg;
	private String cpf;
	private String nome, nomeDaMae, nomeDoPai;
	private String cep,endereco, municipio, bairro,estado;
	private int nCasa;
	private String sResidenciaFixa, nResidenciaFixa;
	private String telefoneFixo,celular, whatsapp, email;
	private String profissaoAtual, remuneracao, renda, statusMatrimonial;
	private boolean ativado, desativado;
	//Status Matrimonial = class Enum
	public boolean isDesativado() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getErrorMessage() {
		return "Cliente não encontrado";
	}

	public ClientePF(ClientePF clientePF) {
		
	}


	
}
