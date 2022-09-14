package br.com.filipe.brenner.controle.estudante.controller;

import br.com.filipe.brenner.controle.estudante.dto.http.ResponseWrapper;
import br.com.filipe.brenner.controle.estudante.dto.subject.CreateSubjectRequestDTO;
import br.com.filipe.brenner.controle.estudante.dto.subject.DeleteSubjectRequestDTO;
import br.com.filipe.brenner.controle.estudante.dto.subject.EditSubjectRequestDTO;
import br.com.filipe.brenner.controle.estudante.dto.subject.SubjectResponseDTO;
import br.com.filipe.brenner.controle.estudante.exceptions.NotFoundException;
import br.com.filipe.brenner.controle.estudante.model.Subject;
import br.com.filipe.brenner.controle.estudante.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    private static final Logger logger = LogManager.getLogger(SubjectController.class);

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateSubjectRequestDTO payload){
        try{
            Subject newSubject = service.create(payload);
            SubjectResponseDTO responseBody = new SubjectResponseDTO(newSubject);
            logger.info(String.format("Disciplina %s criada com sucesso!", newSubject));
            return ResponseWrapper.createResponse(responseBody,true, HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Não foi possível criar uma disciplina", e);
            return ResponseWrapper.createResponse(e,false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<Object> list(){
        try {
            List<Subject> allSubjects = service.listAll();
            List<SubjectResponseDTO> responseBody = allSubjects.stream()
                    .map(SubjectResponseDTO::new)
                    .collect(Collectors.toList());
            if(responseBody.size() == 0){
                throw new NotFoundException("Nenhuma disciplina foi encontrada!");
            } else {
                logger.info(String.format("Obtido todas as %d disciplina(s) com sucesso!", responseBody.size()));
                return ResponseWrapper.createResponse(responseBody,true, HttpStatus.OK);
            }
        } catch (NotFoundException e){
            logger.error(e.getMessage(), e);
            return ResponseWrapper.createResponse(e,false, HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error("Não foi possível listar todas as disciplinas", e);
            return ResponseWrapper.createResponse(e,false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/edit")
    public ResponseEntity<Object> edit(@RequestBody EditSubjectRequestDTO payload){
        try {
            Subject newSubject = service.edit(payload);
            SubjectResponseDTO responseBody = new SubjectResponseDTO(newSubject);
            logger.info(String.format("Disciplina com id: %d editada com sucesso", newSubject.getId()));
            return ResponseWrapper.createResponse(responseBody,true, HttpStatus.OK);
        } catch (NotFoundException e){
            logger.error(e.getMessage(), e);
            return ResponseWrapper.createResponse(e,false, HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error(String.format("Não foi possível editar a disciplina %s", payload), e);
            return ResponseWrapper.createResponse(e,false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody DeleteSubjectRequestDTO payload){
        try {
            Subject subject = service.delete(payload.getId());
            SubjectResponseDTO responseBody = new SubjectResponseDTO(subject);
            logger.info(String.format("Disciplina [%s] com id: %d apagada com sucesso", subject, subject.getId()));
            return ResponseWrapper.createResponse(responseBody, true, HttpStatus.OK);
        }catch (NotFoundException e){
            logger.error(e.getMessage(), e);
            return ResponseWrapper.createResponse(e,false, HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error(String.format("Não foi possível apagar a disciplina %s", payload), e);
            return ResponseWrapper.createResponse(e,false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
