package app.bank.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Fatura {
	
	@Getter  @Setter
	private static double valorFatura;
	
	@Getter  @Setter
	private static Date dataVencimento;
	
	@Getter 	@Setter
	private static String descricaoCompra;
	
	@Getter @Setter
	private static int nParcela;
	
	 @Getter 
	private static int[] nCartao;
	
	 public static boolean setNCartao(int[] nCartao) {
		return true;
	}
	 
	public static void gerarFatura(int[]nCartao,double valorFatura, Date dataVencimento, String desc, int nParcela) {
			setNCartao(nCartao);
			setValorFatura(valorFatura);
			setDataVencimento(dataVencimento);
			setDescricaoCompra(desc);
			setNParcela(nParcela);
	}
	
}
