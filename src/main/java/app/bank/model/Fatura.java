package app.bank.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;


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
	 

	public Fatura getNCartao(int[] nCartao2) {
		Fatura nCartao = ConverteFatura.faturaConverte(nCartao2);
		return nCartao;
	}

	public Fatura getValorFatura(double valorFatura) {
		Fatura valorDaFatura = ConverteFatura.faturaConverte(valorFatura);
		return valorDaFatura;
	}
	
	public Fatura getDataVencimento(Date dataVencimento) {
		Fatura dataDeVencimento = ConverteFatura.faturaConverte(dataVencimento);
		return dataDeVencimento;
	}

	public Fatura getDescricaoCompra(String descricao) {
		Fatura desc = ConverteFatura.faturaConverte(descricao);
		return desc;
	}
	
	public Fatura getNParcela(int nParcela) {
		Fatura nmParcela = ConverteFatura.faturaConverte(dataVencimento);
		return nmParcela;
	}
	
	public static void gerarFatura(int[]nCartao,double valorFatura, Date dataVencimento, String desc, int nParcela) {
			setNCartao(nCartao);
			setValorFatura(valorFatura);
			setDataVencimento(dataVencimento);
			setDescricaoCompra(desc);
			setNParcela(nParcela);
	}	
}


class ConverteFatura{
	
	
	public static Fatura faturaConverte(Object fatura) {
		if(fatura != null) {
			return (Fatura) fatura;
		}
		return null;
	}
	
}
