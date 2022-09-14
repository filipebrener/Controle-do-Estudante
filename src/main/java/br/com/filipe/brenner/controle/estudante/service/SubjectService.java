package br.com.filipe.brenner.controle.estudante.service;

import br.com.filipe.brenner.controle.estudante.dto.subject.CreateSubjectRequestDTO;
import br.com.filipe.brenner.controle.estudante.dto.subject.EditSubjectRequestDTO;
import br.com.filipe.brenner.controle.estudante.exceptions.NotFoundException;
import br.com.filipe.brenner.controle.estudante.model.Subject;
import br.com.filipe.brenner.controle.estudante.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    public Subject create(CreateSubjectRequestDTO payload) {
        Subject newSubject = new Subject(payload);
        return repository.saveAndFlush(newSubject);
    }

    public List<Subject> listAll() throws NotFoundException {
        List<Subject> list = repository.findAll();
        if(list.size() == 0){
            throw new NotFoundException("Nenhuma disciplina foi encontrada!");
        }
        return list;
    }

    public Subject edit(EditSubjectRequestDTO payload) throws NotFoundException {
        Subject subject = getSubjectById(payload.getId());
        subject.setName(payload.getName());
        subject.setCode(payload.getCode());
        subject.setTeacher(payload.getTeacher());
        subject.setTotalPoints(payload.getTotalPoints());
        subject.setMinimumAverage(payload.getMinimumAverage());
        return repository.saveAndFlush(subject);
    }

    public Subject delete(Long id) throws NotFoundException {
        Subject subject = getSubjectById(id);
        repository.delete(subject);
        return subject;
    }

    public Subject getSubjectById(Long id) throws NotFoundException {
        Optional<Subject> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new NotFoundException(Subject.class,id);
        }
        return optional.get();
    }

}
