package app.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.bank.model.ContaPF;

public interface ContaPFRepo extends JpaRepository<ContaPF, Integer>{

}
