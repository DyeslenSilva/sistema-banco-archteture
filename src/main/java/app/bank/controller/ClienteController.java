package app.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.bank.model.ClientePF;
import app.bank.model.ClientePJ;
import app.bank.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private ClienteService clienteService;
	

	@PostMapping("/clientePf")
	public ResponseEntity<ClientePF> cadastroCliente(@PathVariable ClientePF clientePF, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			clienteService.cadastrarCliente(clientePF);
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping("/clientePF/{cpf}")
	public ResponseEntity<ClientePF> getClientePF(@PathVariable String cpf, BindingResult bindingResult)  {
			if(bindingResult.hasErrors()) {
				return ResponseEntity.badRequest().build();
			}else {
				clienteService.clientePorCPF(cpf);
				return ResponseEntity.ok().build();
			}
	}
	
	@GetMapping("/clientePF/{rg}")
	public ResponseEntity<ClientePF> getClientePf(@PathVariable String rg, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			clienteService.clientePorRG(rg);
			return ResponseEntity.ok().build();
		}
	}
	
	@PostMapping("/clientePJ")
	public ResponseEntity<ClientePJ> cadastroPJ(@PathVariable ClientePJ clientePJ, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			clienteService.cadastroEntidade(clientePJ);
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping("/clientePJ/{cnpj}")
	public ResponseEntity<ClientePJ> getClientePJ(@PathVariable String cnpj, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			clienteService.clientePorRG(cnpj);
			return ResponseEntity.ok().build();
		}
	}
	

}
