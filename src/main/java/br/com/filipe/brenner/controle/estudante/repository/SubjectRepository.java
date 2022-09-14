package br.com.filipe.brenner.controle.estudante.repository;

import br.com.filipe.brenner.controle.estudante.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
