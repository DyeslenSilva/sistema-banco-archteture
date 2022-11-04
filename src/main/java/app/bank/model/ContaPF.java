package app.bank.model;

import lombok.Data;

@Data
public class ContaPF extends ContaBancaria{
		private ClientePF clientePF;
		private boolean ativado, desativado;
}
