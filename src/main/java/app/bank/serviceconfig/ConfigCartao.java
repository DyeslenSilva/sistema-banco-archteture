package app.bank.serviceconfig;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConfigCartao {

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
