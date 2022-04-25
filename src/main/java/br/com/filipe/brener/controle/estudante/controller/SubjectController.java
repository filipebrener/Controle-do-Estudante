package br.com.filipe.brener.controle.estudante.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.filipe.brener.controle.estudante.model.Subject;
import br.com.filipe.brener.controle.estudante.repository.SubjectRepository;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    
    private static final Logger log = LogManager.getLogger(ActivityController.class);
    
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    @RequestMapping("/{id}")    
    public ResponseEntity<Subject> getOne(@PathVariable String id){
        Subject subject = null;
        HttpStatus status;
        try {
            subject = subjectRepository.getById(Long.valueOf(id));
            status = (subject != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao encontrar uma disciplina!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(subject,status);
    }

    @GetMapping
    @RequestMapping("/list")
    public ResponseEntity<List<Subject>> list(){
        List<Subject> subjectList = new ArrayList<>();
        HttpStatus status;
        try{
            subjectList = subjectRepository.findAll();
            status = subjectList.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch(Exception e){
            log.error("Erro ao buscar a lista de disciplinas!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(subjectList,status);
    }

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Subject> create(@RequestBody Subject subject){
        Subject savedSubject = null;
        HttpStatus status = HttpStatus.OK;
        try {
            savedSubject = subjectRepository.save(subject);
        } catch (Exception e) {
           log.error("Erro ao criar uma disciplina!",e.getMessage());
           status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(savedSubject,status);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Subject> delete(@PathVariable String id){
        Subject Subject = null;
        HttpStatus status;
        try {
            Subject = subjectRepository.getById(Long.valueOf(id));
            subjectRepository.delete(Subject);
            status = (Subject != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao apagar uma disciplina",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(Subject,status);
    }

    @PutMapping
    @RequestMapping("/edit/{id}")
    public ResponseEntity<Subject> edit(@PathVariable String id,@RequestBody Subject newSubject){
        Subject oldSubject = null;
        Subject editedSubject = null;
        HttpStatus status;
        try {
            oldSubject = subjectRepository.getById(Long.valueOf(id));
            if (oldSubject != null){
                oldSubject.edit(newSubject);
                editedSubject = subjectRepository.save(oldSubject);
            }
            status = (editedSubject != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao editar uma disciplina",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(editedSubject,status);
    }

}
