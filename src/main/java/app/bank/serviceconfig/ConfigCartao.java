package app.bank.serviceconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConfigCartao {

	static Scanner config = new Scanner(System.in);
	static List<String> nomeCliente = new ArrayList<>();
	

	public static void adicionarNome(String nomeCompleto) {
		nomeCompleto = config.nextLine();
		nomeCliente.add(nomeCompleto);
	}
	
	public static void imprimirNomeLista() {
		for(int i=0; i<nomeCliente.size(); i++) {
			System.out.println(nomeCliente.get(i));
		}
	}
	
	public static int gerarNumeroDoCartao(int min, int max) {
		Random cartao = new Random();
		return (cartao.nextInt(max-(min-1))+min);
	}
	
	static List<Integer> numeroCartao = IntStream.generate(()-> gerarNumeroDoCartao(1001, 9999))
			.limit(4).distinct().boxed().collect(Collectors.toList());
	
	public static void imprimirNumeroDoCarao() {
		numeroCartao.forEach(numeroCartao -> System.out.println(numeroCartao));
	}
	
	
	
}
