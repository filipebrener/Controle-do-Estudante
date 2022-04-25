package br.com.filipe.brener.controle.estudante.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import br.com.filipe.brener.controle.estudante.model.User;
import br.com.filipe.brener.controle.estudante.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
        
    private static final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable String id){
        User user = null;
        HttpStatus status;
        try {
            user = userRepository.getById(Long.valueOf(id));
            status = (user != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao encontrar uma atividade!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(user,status);
    }

    @GetMapping
    @RequestMapping("/list")
    public ResponseEntity<List<User>> list(){
        List<User> userList = new ArrayList<>();
        HttpStatus status;
        try{
            userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
            status = userList.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch(Exception e){
            log.error("Erro ao buscar a lista de atividades!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(userList,status);
    }

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        User savedUser = null;
        HttpStatus status = HttpStatus.OK;
        try {
            savedUser = userRepository.save(user);
        } catch (Exception e) {
            log.error("Erro ao criar uma atividade!");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(savedUser,status);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable String id){
        User user = null;
        HttpStatus status;
        try {
            user = userRepository.getById(Long.valueOf(id));
            userRepository.delete(user);
            status = (user != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao apagar uma atividade!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(user,status);
    }

    @PutMapping
    @RequestMapping("/edit/{id}")
    public ResponseEntity<User> edit(@PathVariable String id, @RequestBody User newUser){
        User oldUser = null;
        User editedUser = null;
        HttpStatus status;
        try {
            oldUser = userRepository.getById(Long.valueOf(id));
            if (oldUser != null){
                oldUser.edit(newUser);
                editedUser = userRepository.save(oldUser);
            }
            status = (editedUser != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao editar uma atividade!",e.getMessage());
            System.out.println(e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(editedUser,status);
    }

}
