package br.com.filipe.brenner.controle.estudante.repository;

import br.com.filipe.brenner.controle.estudante.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

    public Optional<UserModel> findByUsername(String username);
}
