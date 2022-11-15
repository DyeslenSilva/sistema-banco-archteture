package app.bank.model;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder.In;

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
	
	@Getter @Setter
	private static int senhaFatura;
	
	
	 @Getter 
	private static int[] nCartao;
	 
	 public static boolean setNCartao(int[] nCartao) {
		return true;
	}
	 
	 public static Fatura getFatura() {
		 Fatura fatura = new Fatura();
		 return fatura;
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
		Fatura nmParcela = ConverteFatura.faturaConverte(nParcela);
		return nmParcela;
	}
	
	
	public Fatura getSenhaFatura(int senha) {
		Fatura senhaFatura = ConverteFatura.faturaConverte(senha);
		return senhaFatura;
	}
	
	public static Fatura gerarFatura(int[]nCartao,double valorFatura, Date dataVencimento, String desc, int nParcela) {
			Fatura fatura = getFatura();
			fatura.getNCartao(nCartao).getValorFatura(valorFatura).getDescricaoCompra(desc)
				.getNParcela(nParcela);
			return fatura;
	}
	
	public static Fatura consultaFatura(int [] nCartao,  int senha) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getSenhaFatura(senha);
		return fatura;
	}
	
	public void pagamentoFatura(int[] nCartao,double valorFatura, int senha) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getValorFatura(valorFatura)
			.getSenhaFatura(senha);
	}

	public static Fatura gerarFatura(boolean setNCartao, Object setValorFatura, Object setDataVencimento,
			Object setDescricaoCompra, Object setNParcela, String desc) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getValorFatura(valorFatura).getDescricaoCompra(desc)
			.getNParcela(nParcela);
		return fatura;
	}

	public static Fatura gerarFaturaF(boolean setNCartao, Object setValorFatura, Object setDataVencimento,
			Object setDescricaoCompra, Object setNParcela) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getValorFatura(valorFatura).getDescricaoCompra(setDescricaoCompra.toString())
			.getNParcela(nParcela);
		return fatura;
	}

	public static Fatura consultaFatura(boolean setNCartao, Object setSenhaFatura) {
		Fatura fatura = getFatura();
		fatura.getNCartao(setNCartao).
				getSenhaFatura(Integer.parseInt(setSenhaFatura.toString()));
		return fatura;
	}

	private Fatura getNCartao(boolean setNCartao) {
		return null;
	}

	public Fatura pagamentoFatura(boolean setNCartao, Object setValorFatura, Object setSenhaFatura) {
		Fatura fatura = getFatura();
		fatura.getNCartao(nCartao).getValorFatura(valorFatura)
			.getSenhaFatura(Integer.parseInt(setSenhaFatura.toString()));
		return fatura;
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
