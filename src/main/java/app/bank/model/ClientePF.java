package app.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clientePF")
public class ClientePF {

	@Id
	private String rg;
	private String cpf;
	private String nome, nomeDaMae, nomeDoPai;
	private String cep,endereco, municipio, bairro,estado;
	private int nCasa;
	private String sResidenciaFixa, nResidenciaFixa;
	private String telefoneFixo,celeuar, whatsapp, email;
	private String profissaoAtual, remuneracao, renda, statusMatrimonial;
	private boolean ativado, desativado;
	//Status Matrimonial = class Enum
	public boolean isDesativado() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
