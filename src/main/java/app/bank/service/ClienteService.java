package app.bank.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.bank.model.ClientePF;
import app.bank.model.ClientePJ;
import app.bank.repo.ClientePFRepo;
import app.bank.repo.ClientePJRepo;

@Service
public class ClienteService {

	@Autowired
	private ClientePFRepo clientePFRepo;
	
	@Autowired
	private ClientePJRepo clientePJRepo;
	
	public void cadastrarCliente(ClientePF clientePF) {
		clientePFRepo.save(clientePF);
	}
	
	public void cadastroEntidade(ClientePJ clientePJ) {
		clientePJRepo.save(clientePJ);
	}
	
	public List<ClientePF> listaClientes(){
		return clientePFRepo.findAll().stream()
				.filter(pf -> pf.isDesativado()).toList();
	}
	
	public List<ClientePJ> listaEntidades(){
		return clientePJRepo.findAll().stream()
					.filter(pj -> pj.isDesativado()).toList();
	}
	
	public ClientePF clientePorCPF(String cpf) {
		return clientePFRepo.findById(cpf).orElse(null);
	}
	
	public ClientePF clientePorRG(String rg) {
		return clientePFRepo.findById(rg).orElse(null);
	}
	
	public ClientePJ clientePorCNPJ(String cnpj) {
		return clientePJRepo.findById(cnpj).orElse(null);
	}
	
	public ClientePF atualizarClientePF(String cpf, ClientePFRepo cliPFRepo) {
		Optional<ClientePF> cliente  = cliPFRepo.findById(cpf);
		if(cliente.isPresent()) {
				cliente.get().getRg();
				cliente.get().getCpf();
				cliente.get().getNome();
				cliente.get().getCep();
				cliente.get().getEndereco();
				cliente.get().getNCasa();
				cliente.get().getBairro();
				cliente.get().getMunicipio();
				cliente.get().getEstado();
				cliente.get().getEmail();
				cliente.get().getNomeDaMae();
				cliente.get().getNomeDoPai();
				cliente.get().getTelefoneFixo();
				cliente.get().getWhatsapp();
				cliente.get().getProfissaoAtual();
				cliente.get().getRemuneracao();
				cliente.get().getRenda();
				cliente.get().getStatusMatrimonial();
				cliente.get().getSResidenciaFixa();
				cliente.get().getNResidenciaFixa();
		}
		return null;
	}
	
	public void removeClientePorCPF(String [] lista) {
		Arrays.stream(lista).forEach(cpf-> {
			ClientePF clientePF = clientePorCPF(cpf);
			if(clientePF!=null) {
				clientePF.setAtivado(false);
				clientePFRepo.deleteById(cpf);
			}
		});
	}
	
	public void removeClientePorRG(String[] lista) {
		Arrays.stream(lista).forEach(rg->{
			ClientePF cliente = clientePorRG(rg);
			if(cliente!=null) {
				cliente.setAtivado(false);
				clientePFRepo.deleteById(rg);
			}
		});
	}
	
	public void removeEntidade(String[] lista) {
		Arrays.stream(lista).forEach(cnpj->{
			ClientePJ clientePJ = clientePorCNPJ(cnpj);
			if(clientePJ !=null) {
				clientePJ.setAtivado(false);
				clientePJRepo.deleteById(cnpj);
			}
		});
	}
		
}
