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
	
	@SuppressWarnings("static-access")
	public ResponseEntity<Cartoes> vinculoCartaoDebitoPF(@PathVariable ClientePF clientePF, Cartoes cartoes){
		int nConta= getNConta();
		int nCartao = getNCartao();
		boolean vinculoPF = getClientePF(clientePF.nConta(nConta).setNCartao(nCartao));
		if(vinculoPF==false) {
			cartoesServices.vincularCDebitoFAConta(cartoes.getNCartao(), contaPF.getNumeroContaBancaria());
			getClientePF(clientePF.nConta(nConta).setNCartao(nCartao));
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	


	@SuppressWarnings("static-access")
	public ResponseEntity<Cartoes> vinculoCartaoDeDebitoPJ(@PathVariable ClientePJ clientePJ, Cartoes cartoes){
		int nConta = getNConta();
		int nCartao = getNCartao();
		boolean vinculoPJ = getClientePJ(clientePJ.nConta(nConta).setNCartao(nCartao));
		if(vinculoPJ==false) {
			cartoesServices.vincularCDebitoJAConta(cartoes.getNCartao(), contaPF.getNumeroContaBancaria());
			getClientePJ(clientePJ.nConta(nConta).setNCartao(nCartao));
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	@SuppressWarnings("static-access")
	public ResponseEntity<Cartoes> vinculoCartaoDeDCreditoPF(@PathVariable ClientePF clientePF, Cartoes cartoes){
		int nConta = getNConta();
		int nCartao = getNCartao();
		boolean vinculloPF = getClientePF(clientePF.nConta(nConta).setNCartao(nCartao));
		if(vinculloPF == false) {
			cartoesServices.vincularCCreditoFAConta(cartoes.getNCartao(), contaPF.getNumeroContaBancaria());
			getClientePF(clientePF.nConta(nConta).setNCartao(nCartao));
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	@SuppressWarnings("static-access")
	public ResponseEntity<Cartoes> vinculoCartaoDeCreditoPJ(@PathVariable ClientePJ clientePJ, Cartoes cartoes){
		int nConta = getNCartao();
		int nCartao = getNCartao();
		boolean vinculloPJ = getClientePJ(clientePJ.nConta(nConta).setNCartao(nCartao));
		if(vinculloPJ == false) {
			cartoesServices.vincularCCreditoJAConta(cartoes.getNCartao(), contaPJ.getNumeroContaBancaria());
			getClientePJ(clientePJ.nConta(nConta).setNCartao(nCartao));
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

	private boolean getClientePJ(int[] setNCartao) {
		if (setNCartao.equals(setNCartao)) {
			return true;
		}
		return false;
	}
	
	private int getNCartao() {
		int nCartao = Integer.hashCode(getNCartao());
		return nCartao;
	}

	private int getNConta() {
		int nConta = Integer.hashCode(getNConta());
		return nConta;
	}

	@SuppressWarnings("unused")
	private boolean getClientePF(ClientePF clientePF) {
		if(clientePF.isAtivado()) {
			return true;
		}else if(clientePF.isDesativado()) {
			return false;
		}
		return false;
	}

	private boolean getClientePF(int[] nCartao) {
		if(nCartao.equals(nCartao)) {
			return true;
		}else if(nCartao.equals(nCartao)) {
			return false;
		}
		return false;
	}

	private boolean getClientePJ(String cnpj) {
		if(cnpj.equals(cnpj)) 
			return true;
		return false;
		
	}
	
	private boolean getClientePF(String cpf) {
		if(cpf.equals(cpf)) 
			return true;
		return false;
	}

}
