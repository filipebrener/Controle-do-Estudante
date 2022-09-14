package br.com.filipe.brenner.controle.estudante.controller;

import br.com.filipe.brenner.controle.estudante.dto.CreateSubjectDTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    // TODO implementar controller da disciplina

    @PostMapping("/create")
    public ResponseEntity<CreateSubjectDTOResponse> create(){
       return new ResponseEntity<>(new CreateSubjectDTOResponse(), HttpStatus.OK);
    }
}
