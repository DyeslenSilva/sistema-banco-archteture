package app.bank.service;

import org.springframework.stereotype.Service;

import antlr.collections.List;
import app.bank.model.ContaPF;
import app.bank.model.ContaPJ;
import app.bank.repo.ContaPFRepo;
import app.bank.repo.ContaPJRepo;

@Service
public class ContaSevice {
	
	private ContaPFRepo contaPFRepo;
	private ContaPJRepo contaPJRepo;
	
	public boolean abrirContaPF(ContaPF contaPF) {
		boolean saveCliente = contaPFRepo.save(contaPF) != null;
		return saveCliente;
	}
	
	public boolean abrirContaPJ(ContaPJ contaPJ) {
		boolean saveCliente = contaPJRepo.save(contaPJ) != null;
		return saveCliente;
	}
	
	public java.util.List<ContaPF> getAllContaPF(){
		return contaPFRepo.findAll();
	}
	
	public java.util.List<ContaPJ> getAllContaPJ(){
		return contaPJRepo.findAll();
	}
	
	
}
