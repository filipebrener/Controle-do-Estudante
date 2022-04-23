package br.com.filipe.brener.controle.estudante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filipe.brener.controle.estudante.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long>{
    
}
