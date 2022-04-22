package br.com.filipe.brener.controle.estudante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filipe.brener.controle.estudante.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity,Long>{
    
}
