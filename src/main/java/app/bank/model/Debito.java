package app.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Debito extends Cartoes {
	
	@Getter 	@Setter
	private static ContaPF contaPF;
	
	@Getter @Setter
	private static ContaPJ contaPJ;
	
	@Getter @Setter
	private int[] nCartao;
	
	
	public static double consultaSaldo(ClientePF clientePF, ClientePJ clientePJ, int senha) {
		 double saldo=Cartoes.getSaldoDebito();
		 if (contaPF.setClientePF(clientePF.getCpf()) && contaPF.setSenha(senha)) {
			 	return	contaPF.setSaldo(saldo);
		 }
		 
		 if(contaPJ.setClientePJ(clientePJ.getCNPJ())&& contaPJ.setSenha(senha)) {
			 return contaPJ.setSaldo(saldo);
		 }
		return saldo;
	}
}
