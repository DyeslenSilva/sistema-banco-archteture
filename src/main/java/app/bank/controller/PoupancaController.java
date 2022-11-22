package app.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import app.bank.model.Poupanca;
import app.bank.service.PoupancaService;

@RestController
public class PoupancaController {

	private PoupancaService poupancaService;
	
	@GetMapping("/cdb/{capital}/{taxa}/{tempo}")
	public  ResponseEntity<Poupanca> poupancaCDB(@PathVariable Poupanca poupanca){
		poupancaService.cdb(poupanca.getCapital(), poupanca.getTaxaDeJuros(), poupanca.getTempo());
			return ResponseEntity.ok().build();
	}
	
	@GetMapping("cdi/{capital}/{taxa}/{tempo}")
	public ResponseEntity<Poupanca> poupancaCDI(@PathVariable Poupanca poupanca){
		poupancaService.cdi(poupanca.getCapital(), poupanca.getTaxaDeJuros(), poupanca.getTempo());
		return ResponseEntity.ok().build();
	}
	
}
