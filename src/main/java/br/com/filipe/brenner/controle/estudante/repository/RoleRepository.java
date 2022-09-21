package br.com.filipe.brenner.controle.estudante.repository;

import br.com.filipe.brenner.controle.estudante.model.Enum.RoleName;
import br.com.filipe.brenner.controle.estudante.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    public Optional<Role> findByRoleName(RoleName roleName);

}
