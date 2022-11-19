package app.bank.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContaCorrente {
		private ContaCorrente[] conta;

		private  int getNumeroConta(int nConta) {
			return nConta;
		}
		
		private int getSenha(int senha) {
			return senha;
		}

		public void extrato(int nCartao, int senha) {
			int numCartao = getNumeroConta(nCartao);
			int senhaCartao = getSenha(senha);
			 List<String> extrato = new ArrayList<>();
			 for(ContaCorrente corrente : conta) {
				 corrente.extrato(numCartao, senhaCartao);
			retorno(extrato);						
			 }
		}

		private List<String> retorno(List<String> extrato) {
			return extrato;
		}

		
}
