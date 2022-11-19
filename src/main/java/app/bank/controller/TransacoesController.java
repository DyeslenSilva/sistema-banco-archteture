package app.bank.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import app.bank.enumeratiom.TipoChave;

import app.bank.model.Transacoes;
import app.bank.service.TransacoesService;

public class TransacoesController {

	private TransacoesService transacoesService;
	
	@PostMapping("/deposito/{conta}/{valor}")
	public ResponseEntity<Transacoes> realizarDeposito(@PathVariable Integer conta, @PathVariable Double valor){
		transacoesService.realizarDeposito(conta, valor);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("transfereciadoc/{contaOrigem}/{contaDestino}/{valor}")
	public ResponseEntity<Transacoes> transferenciaDOC(@PathVariable Integer contaOrigem, 
								@PathVariable Integer contaDestino, @PathVariable Double valor){
		transacoesService.realizarTransfereciaDOC(contaOrigem, contaDestino, valor);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/transferenciated/{contaOrigem}/{contaDestino}/{valor}/{tempo}")
	public ResponseEntity<Transacoes> transferenciaTED(@PathVariable Integer contaOrigem,
					@PathVariable Integer contaDestino, @PathVariable Double valor, 
					@PathVariable Integer tempo){
		transacoesService.realizarTransferenciaTED(contaOrigem, contaDestino, valor, tempo);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("pix/{tipoChave}/{chave}/{valor}")
	public ResponseEntity<Transacoes> transferenciaPIX(@PathVariable TipoChave[] tipoChave,
					@PathVariable String chave,@PathVariable Double valor){
		transacoesService.realizarPIX(tipoChave,chave, valor);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/pix/{tipoChave}/{chave}/{valor}/{data}")
	public ResponseEntity<Transacoes> transaferenciaPIXProg(@PathVariable TipoChave[] tipoChave,
			@PathVariable Double valor, @PathVariable String chave,@PathVariable Date data){
		transacoesService.pixProgramado(tipoChave, chave,valor, data);
		return ResponseEntity.ok().build();
	}
}


