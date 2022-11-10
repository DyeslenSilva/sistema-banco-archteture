package app.bank.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import app.bank.model.ClientePF;
import app.bank.model.ClientePJ;
import app.bank.model.ContaPF;
import app.bank.model.ContaPJ;
import app.bank.service.ContaService;

@Controller
public class ContasController {

	private ContaService contaService;
	private ClientePF clientePF;
	
	@PostMapping("/contaPF/abertura")
	public ResponseEntity<ContaPF> aberturaContaPF(@PathVariable ContaPF contaPF, BindingResult bindingResult){
		Optional<ContaPF> aberturaPF = contaService.getContaPF(contaPF.getNumeroContaBancaria());
		if(aberturaPF.isEmpty()) {
			contaService.abrirContaPF(contaPF);
			return ResponseEntity.ok().build();
		}else {
			contaService.getContaPFrg(clientePF.getRg());
			contaService.getContaPFcpf(clientePF.getCpf());
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping("/contaPF/{rg}")
	public ResponseEntity<ClientePF> contaPorRG(@PathVariable ClientePF clientePF, 
				@PathVariable ContaPF contaPF){
		Optional<ClientePF> contaRG = contaService.getContaPFrg(clientePF.getRg());
		if(contaRG.isPresent()) {
			contaService.getContaPFrg(clientePF.getRg());
			return ResponseEntity.ok().build();
		}else {
			contaService.abrirContaPF(contaPF);
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping("/contaPF/{cpf}")
	public ResponseEntity<ClientePF> contaPorCPF(@PathVariable ClientePF clientePF,
			@PathVariable ContaPF contaPF){
		Optional<ClientePF> contaCPF = contaService.getContaPFcpf(clientePF.getCpf());
		if(contaCPF.isPresent()) {
			contaService.getContaPFcpf(clientePF.getCpf());
			return ResponseEntity.ok().build();
		}else {
			contaService.abrirContaPF(contaPF);
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping("/contaPJ/{cnpj}")
	public ResponseEntity<ClientePJ> contaPorCNPJ(@PathVariable ClientePJ clientePJ,
			@PathVariable ContaPJ contaPJ){
		Optional<ClientePJ> pjConta = contaService.getContaPJ(clientePJ.getCNPJ());
		if (pjConta.isPresent()) {
			contaService.getContaPJ(clientePJ.getCNPJ());
			return ResponseEntity.ok().build();
		}else {
			contaService.abrirContaPJ(contaPJ);
			return ResponseEntity.ok().build();
		}
 	}
	
	@GetMapping("/contaPF")
	public ResponseEntity<ClientePF> todasAsContasPF(){
		contaService.getAllContaPF();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/contaPJ")
	public ResponseEntity<ClientePJ> todasAsContasPJ(){
		contaService.getAllContaPJ();
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/conta/{cpf}")
	public ResponseEntity<ClientePF> alterandoContaPF(ClientePF clientePF,ContaPF contaPF){
			Optional<ClientePF> clientePFf = contaService.getContaPFcpf(clientePF.getCpf());
			if(clientePFf.isPresent()) {
				contaService.updateContaPF(clientePF.getCpf());
				contaService.updateContaPF(contaPF.getNumeroContaBancaria(), contaPF);
				return ResponseEntity.ok().build();
			}else {
				return ResponseEntity.badRequest().build();
			}
	}
	
	@PutMapping("/conta/{cnpj}")
	public ResponseEntity<ClientePJ> alterandoContaPJ(ClientePJ clientePJ, ContaPJ pj){
		Optional<ClientePJ> clientePJs = contaService.getContaPJ(clientePJ.getCNPJ());
		if(clientePJs.isPresent()) {
			contaService.updateContaPJ(clientePJ.getCNPJ());
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
}
