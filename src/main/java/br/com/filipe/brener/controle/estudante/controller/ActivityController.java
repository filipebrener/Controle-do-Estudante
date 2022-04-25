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

import br.com.filipe.brener.controle.estudante.model.Activity;
import br.com.filipe.brener.controle.estudante.repository.ActivityRepository;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    
    private static final Logger log = LogManager.getLogger(ActivityController.class);

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Activity> getOne(@PathVariable String id){
        Activity activity = null;
        HttpStatus status;
        try {
            activity = activityRepository.getById(Long.valueOf(id));
            status = (activity != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao encontrar uma atividade!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(activity,status);
    }

    @GetMapping
    @RequestMapping("/list")
    public ResponseEntity<List<Activity>> list(){
        List<Activity> activityList = new ArrayList<>();
        HttpStatus status;
        try{
            activityList = activityRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
            status = activityList.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch(Exception e){
            log.error("Erro ao buscar a lista de atividades!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(activityList,status);
    }

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Activity> create(@RequestBody Activity activity){
        Activity savedActivity = null;
        HttpStatus status = HttpStatus.OK;
        try {
            savedActivity = activityRepository.save(activity);
        } catch (Exception e) {
           log.error("Erro ao criar uma atividade!");
           status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(savedActivity,status);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Activity> delete(@PathVariable String id){
        Activity activity = null;
        HttpStatus status;
        try {
            activity = activityRepository.getById(Long.valueOf(id));
            activityRepository.delete(activity);
            status = (activity != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao apagar uma atividade!",e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(activity,status);
    }

    @PutMapping
    @RequestMapping("/edit/{id}")
    public ResponseEntity<Activity> edit(@PathVariable String id, @RequestBody Activity newActivity){
        Activity oldActivity = null;
        Activity editedActivity = null;
        HttpStatus status;
        try {
            oldActivity = activityRepository.getById(Long.valueOf(id));
            if (oldActivity != null){
                oldActivity.edit(newActivity);
                editedActivity = activityRepository.save(oldActivity);
            }
            status = (editedActivity != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            log.error("Erro ao editar uma atividade!",e.getMessage());
            System.out.println(e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(editedActivity,status);
    }

}
