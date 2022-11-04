package app.bank.model;

import lombok.Data;

@Data
public class ContaPJ extends ContaBancaria{
	private ClientePJ clientePJ;
	
	private boolean ativado, desativado;
}
