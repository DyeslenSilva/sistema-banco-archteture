package app.bank.model;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ContaBancaria {
	
	@Id
	private int numeroContaBancaria;
	
}
