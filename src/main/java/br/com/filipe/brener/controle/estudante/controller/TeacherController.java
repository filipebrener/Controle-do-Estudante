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

import br.com.filipe.brener.controle.estudante.model.Teacher;
import br.com.filipe.brener.controle.estudante.repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private static final Logger log = LogManager.getLogger(ActivityController.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    @RequestMapping("/{id}")    
    public ResponseEntity<Teacher> getOne(@PathVariable String id){
        Teacher teacher = null;
        HttpStatus status;
        try {
            teacher = teacherRepository.getById(Long.valueOf(id));
            status = (teacher != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao encontrar um professor!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(teacher,status);
    }

    @GetMapping
    @RequestMapping("/list")
    public ResponseEntity<List<Teacher>> list(){
        List<Teacher> teacherList = new ArrayList<>();
        HttpStatus status;
        try{
            teacherList = teacherRepository.findAll();
            status = teacherList.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch(Exception e){
            log.error("Erro ao pegar a lista de professores!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(teacherList,status);
    }

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Teacher> create(@RequestBody Teacher Teacher){
        Teacher savedTeacher = null;
        HttpStatus status = HttpStatus.OK;
        try {
            savedTeacher = teacherRepository.save(Teacher);
        } catch (Exception e) {
           log.error("Erro ao criar um professor!",e.getMessage());
           status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(savedTeacher,status);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Teacher> delete(@PathVariable String id){
        Teacher Teacher = null;
        HttpStatus status;
        try {
            Teacher = teacherRepository.getById(Long.valueOf(id));
            teacherRepository.delete(Teacher);
            status = (Teacher != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao apagar um professor",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(Teacher,status);
    }

    @PutMapping
    @RequestMapping("/edit/{id}")
    public ResponseEntity<Teacher> edit(@PathVariable String id,@RequestBody Teacher newTeacher){
        Teacher oldTeacher = null;
        Teacher editedTeacher = null;
        HttpStatus status;
        try {
            oldTeacher = teacherRepository.getById(Long.valueOf(id));
            if (oldTeacher != null){
                oldTeacher.edit(newTeacher);
                editedTeacher = teacherRepository.save(oldTeacher);
            }
            status = (editedTeacher != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao editar um professor",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(editedTeacher,status);
    }

}
