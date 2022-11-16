package app.bank.controller;

import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import app.bank.model.Cartoes;
import app.bank.model.ClientePF;
import app.bank.model.ClientePJ;
import app.bank.model.ContaCliente;
import app.bank.model.ContaPF;
import app.bank.model.ContaPJ;
import app.bank.service.CartoesServices;

@RestController
public class CartoesController {
	
	private CartoesServices cartoesServices;
	private Cartoes cartoes;
	int[] nCartao;
	private ContaPF contaPF;
	private ContaPJ contaPJ;
	
	@GetMapping("/gerarCartaoDebito/{min}/{max}/{nomeCliente}")
	public ResponseEntity<Cartoes> gerarCartaoDeDebito(@PathVariable Integer min, 
										@PathVariable Integer max, String nomeCliente, BindingResult bdRes){
		boolean contaOptional = Cartoes.setNCartao(nCartao);
		if(contaOptional==false) {
			cartoesServices.gerarCartaoDeCredito(min, max, nomeCliente);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.accepted().build();
		}
	}
	
	@GetMapping("/gerarCartaoDeCredito/{min}/{max}/{nomeCliente}")
	public ResponseEntity<Cartoes> gerarCartaoDeCredito(@PathVariable Integer min, 
								@PathVariable Integer max, @PathVariable String nomeCliente){
		boolean contaOptional = Cartoes.setNCartao(nCartao);
		if(contaOptional==false) {
			cartoesServices.gerarCartaoDeCredito(min, max, nomeCliente);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.accepted().build();
		}
	}
	
	@GetMapping("/consultaSaldoPF/{cpf}/{senha}")
	public ResponseEntity<Cartoes> consultaSaldoPF(@PathVariable ClientePF clientePF){
		boolean consultaPF = getClientePF(clientePF.getCpf());
		if(consultaPF) {
			cartoesServices.consultaSaldoPF(clientePF.cpf(clientePF.getCpf()), contaPF.getSenha());
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.accepted().build();
		}
	}
	
	@GetMapping("/consultaSaldoPJ/{cnpj}/{senha}")
	public ResponseEntity<Cartoes> consultaSaldoPJ(@PathVariable ClientePJ clientePJ){
		boolean consultaPJ = getClientePJ(clientePJ.getCNPJ());
		if(consultaPJ) {
			cartoesServices.consultaSaldoPJ(clientePJ.cnpj(clientePJ.getCNPJ()), contaPJ.getSenha());
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.accepted().build();
		}
	}
	
	

	private boolean getClientePJ(String cnpj) {
		if(cnpj.equals(cnpj)) 
			return true;
		return false;
		
	}
	
	private boolean getClientePF(String cpf) {
		if(cpf.equals(cpf)) {
			return true;
		}
		return false;
	}

}
