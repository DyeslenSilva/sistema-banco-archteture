package app.bank.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.bank.model.ClientePF;
import app.bank.repo.ClientePFRepo;

@Service
public class ClienteService {

	@Autowired
	private ClientePFRepo clientePFRepo;
	
	public void cadastrarCliente(ClientePF clientePF) {
		clientePFRepo.save(clientePF);
	}
	
	public List<ClientePF> listaClientes(){
		return clientePFRepo.findAll().stream()
				.filter(pf -> pf.isDesativado()).toList();
	}
	
	public ClientePF clientePorCPF(String cpf) {
		return clientePFRepo.findById(cpf).orElse(null);
	}
	
	public ClientePF clientePorRG(String rg) {
		return clientePFRepo.findById(rg).orElse(null);
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
	
}
