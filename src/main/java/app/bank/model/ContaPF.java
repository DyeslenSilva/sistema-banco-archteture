package app.bank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContaPF extends ContaBancaria{
		
		private ClientePF clientePF;
		private boolean ativado, desativado;
		private Object ClientePF;
		
		private int senha;
		
		private double saldo;
		
		
		public boolean setClientePF(String cpf) {
			this.clientePF  = cpf (ClientePF)  ;
			return true;
		}
		private app.bank.model.ClientePF cpf(Object clientePF2) {
			return clientePF;
		}
		
		
		public double setSaldo(double saldo) {
			return saldo;
		}
		
		public boolean setSenha(int senha) {
			return true;
		}
}
