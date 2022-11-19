package app.bank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContaPF extends ContaBancaria{
		
		private ClientePF clientePF;
		private boolean ativado, desativado;
		private Object ClientePF;
		
		
		private double limite;
		
		private int senha;
		
		private double saldo;
		
		
		
		public ContaPF contaPF(int contaPF) {
			ContaPF contaPFf = getContaPF();
			return contaPFf.contaPF(contaPF);
		}
		
		
		private ContaPF getContaPF() {
			return this.contaPF(senha);
		}


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
		
		
		public double setLimite(double limite) {
			return limite;
		}
		
		public boolean setSenha(int senha) {
			return true;
		}
		public void setClientePF(app.bank.model.ClientePF clientePF2) {
			this.clientePF = clientePF2;
		}
		

		public boolean setClientePF(Object setCpf) {
			
			return false;
		}
	
		public String setClientePFf(String cpf) {
			return cpf;
		}
		
		public  ClientePF  pfCliente(ClientePF clientePF) {
			return clientePF = this.clientePF;
		}


		public Object debito(Object vincularCartaoConta) {
			ContaPF contaPFf = getContaPF();
			int contaPF = getNumeroContaBancaria();
			contaPFf.contaPF(contaPF );
			return contaPFf;
		}


		public ContaPF credito(int[] nCartao) {
			ContaPF  cContaPF = getContaPF();
			int nContaPF = getNumeroContaBancaria();
			cContaPF.contaPF(nContaPF);
			return cContaPF;
			
		}


		public ContaPF contaPF(Object setNumeroContaBancaria) {
			ContaPF  cContaPF = getContaPF();
			int nContaPF = getNumeroContaBancaria();
			cContaPF.contaPF(nContaPF);
			return cContaPF;
		}


		public void credito(boolean setNCartao) {
			if (setNCartao) {
				return;
			}
		}


		public Object setNumeroContaBanc(int setNumeroContaBanc) {
			// TODO Auto-generated method stub
			return null;
		}


		public boolean setNumeroConta(int nConta) {
			// TODO Auto-generated method stub
			return false;
		}



//		public void vinculaDebito(Object vincularCartaoConta) {
//			ContaPF contaPFf = getContaPF();
//			int contaPF = getNumeroContaBancaria();
//			contaPFf.contaPF(contaPF );
//			
//		}


		
		
}
