package app.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.bank.model.ClientePF;

public interface ClientePFRepo extends JpaRepository<ClientePF, String> {

}
