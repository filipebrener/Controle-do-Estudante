package br.com.filipe.brenner.controle.estudante.controller;

import br.com.filipe.brenner.controle.estudante.dto.http.ResponseWrapper;
import br.com.filipe.brenner.controle.estudante.dto.student.CreateUserRequestDTO;
import br.com.filipe.brenner.controle.estudante.model.UserModel;
import br.com.filipe.brenner.controle.estudante.repository.UserRepository;
import br.com.filipe.brenner.controle.estudante.service.StudentService;
import br.com.filipe.brenner.controle.estudante.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    private static final Logger logger = LogManager.getLogger(SubjectController.class);

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateUserRequestDTO payload){
        try{
            UserModel user = new UserModel(payload);
            UserModel newUser = repository.saveAndFlush(user);
//            StudentResponseDTO responseBody = new SubjectResponseDTO(newStudent);
            logger.info(String.format("Usuário %s criado com sucesso!", newUser.getUsername()));
            return ResponseWrapper.createResponse(newUser,true, HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Não foi possível criar um usuário", e);
            return ResponseWrapper.createResponse(e,false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}