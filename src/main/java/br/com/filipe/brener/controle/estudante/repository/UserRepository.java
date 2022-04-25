package br.com.filipe.brener.controle.estudante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filipe.brener.controle.estudante.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
