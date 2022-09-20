package br.com.filipe.brenner.controle.estudante.model;

import br.com.filipe.brenner.controle.estudante.dto.subject.CreateSubjectRequestDTO;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String code;

    @ManyToOne
    private UserModel teacher;

    private Float totalPoints;

    private Float minimumAverage;

    public Subject(){
        // Construtor padrão
    }

    public Subject(CreateSubjectRequestDTO payload) {
        name = payload.getName();
        code = payload.getCode();
        teacher = payload.getTeacher();
        totalPoints = payload.getTotalPoints();
        minimumAverage = payload.getMinimumAverage();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserModel getTeacher() {
        return teacher;
    }

    public void setTeacher(UserModel teacher) {
        this.teacher = teacher;
    }

    public Float getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Float totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Float getMinimumAverage() {
        return minimumAverage;
    }

    public void setMinimumAverage(Float minimumAverage) {
        this.minimumAverage = minimumAverage;
    }

    @Override
    public String toString(){
        return String.format("%s - %s",this.code, this.name);
    }

}
