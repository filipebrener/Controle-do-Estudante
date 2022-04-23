package br.com.filipe.brener.controle.estudante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filipe.brener.controle.estudante.model.Teacher;

public interface TheacherRepository extends JpaRepository<Teacher,Long>{
    
}
