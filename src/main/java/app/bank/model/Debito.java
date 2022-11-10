package app.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Debito extends Cartoes {
	
	@Getter 	@Setter
	private ContaPF contaPF;
	
	@Getter @Setter
	private ContaPJ contaPJ;
}
