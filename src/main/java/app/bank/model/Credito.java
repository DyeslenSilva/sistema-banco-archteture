package app.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Credito extends Cartoes{

	@Getter @Setter
	private ClientePF clientePF;
	
	@Getter @Setter
	private ClientePJ clientePJ;
	

}
