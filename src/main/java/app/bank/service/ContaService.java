package app.bank.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import app.bank.model.ClientePF;
import app.bank.model.ClientePJ;
import app.bank.model.ContaPF;
import app.bank.model.ContaPJ;
import app.bank.repo.ClientePFRepo;
import app.bank.repo.ClientePJRepo;
import app.bank.repo.ContaPFRepo;
import app.bank.repo.ContaPJRepo;

@Service
public class ContaService {
	
	private ContaPFRepo contaPFRepo;
	private ContaPJRepo contaPJRepo;
	private ClientePFRepo clientePFRepo;
	private ClientePJRepo clientePJRepo;
	
	public boolean abrirContaPF(ContaPF contaPF) {
		boolean saveCliente = contaPFRepo.save(contaPF) != null;
		return saveCliente;
	}
	
	public boolean abrirContaPJ(ContaPJ contaPJ) {
		boolean saveCliente = contaPJRepo.save(contaPJ) != null;
		return saveCliente;
	}
		
	public java.util.List<ContaPF> getAllContaPF(){
		return contaPFRepo.findAll().stream().filter(ctpf -> 
				ctpf.isDesativado()).toList();
	}
	
	public java.util.List<ContaPJ> getAllContaPJ(){
		return contaPJRepo.findAll().stream().filter(ctpj -> 
					ctpj.isDesativado()).toList();
	}
	
	public Optional<ContaPF> getContaPF(Integer numeroConta) {
		Optional<ContaPF> contaNumero = contaPFRepo.findById(numeroConta);
		return contaNumero;
	}
	
	public Optional<ContaPJ> getContaPJ(Integer numeroConta){
		Optional<ContaPJ> contaNumero = contaPJRepo.findById(numeroConta);
		return contaNumero;
	}
	
	public Optional<ClientePF> getContaPFrg(String rg){
		Optional<ClientePF> rgCliente = clientePFRepo.findById(rg);
		return rgCliente;
	}
	
	public Optional<ClientePF> getContaPFcpf(String cpf){
		Optional<ClientePF> cpfCliente = clientePFRepo.findById(cpf);
		return cpfCliente;
	}
	
	public Optional<ClientePJ> getContaPJ(String cnpj){
		Optional<ClientePJ> cnpjCliente = clientePJRepo.findById(cnpj);
		return cnpjCliente;
	}
	
	public void updateContaPF(String cpf) {
		Optional<ClientePF>  cpfCliente	 = clientePFRepo.findById(cpf);
		if(cpfCliente.isPresent()) {
				cpfCliente.get().getNome();
				cpfCliente.get().getRg();
				cpfCliente.get().getCpf();
				cpfCliente.get().getNomeDaMae();
				cpfCliente.get().getNomeDoPai();
				cpfCliente.get().getCep();
				cpfCliente.get().getEndereco();
				cpfCliente.get().getNCasa();
				cpfCliente.get().getBairro();
				cpfCliente.get().getMunicipio();
				cpfCliente.get().getEstado();
				cpfCliente.get().getEmail();
				cpfCliente.get().getTelefoneFixo();
				cpfCliente.get().getWhatsapp();
				cpfCliente.get().getProfissaoAtual();
				cpfCliente.get().getRemuneracao();
				cpfCliente.get().getRenda();
				cpfCliente.get().getSResidenciaFixa();
				cpfCliente.get().getNResidenciaFixa();
				cpfCliente.get().getStatusMatrimonial();
		}
	}
	
	public void updateContaPJ(String cnpj) {
		Optional<ClientePJ> cnpjCliente = clientePJRepo.findById(cnpj);
		if(cnpjCliente.isPresent()) {
				cnpjCliente.get().getCNPJ();
				cnpjCliente.get().getRazaoSocial();
				cnpjCliente.get().getProprietarioResponsavel();
				cnpjCliente.get().getQuantidadeDeFiliais();
				cnpjCliente.get().getQuantidadeDeEmpregados();
				cnpjCliente.get().getTelefoneResponsavel();
				cnpjCliente.get().getEndereco();
				cnpjCliente.get().getN();
				cnpjCliente.get().getMunicipio();
				cnpjCliente.get().getBairro();
				cnpjCliente.get().getEstado();
		}
	}
	
	public void deleteContaPF(Integer conta) {
		contaPFRepo.deleteById(conta);
	}
	
	public void deleteContaPJ(Integer conta) {
		contaPJRepo.deleteById(conta);
	}
}
