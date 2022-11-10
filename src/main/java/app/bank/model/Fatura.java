package app.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Fatura extends Credito{
	
	@Getter  @Setter
	private double valorFatura;
	
	
}
