package br.com.filipe.brenner.controle.estudante.dto.subject;

import br.com.filipe.brenner.controle.estudante.model.Subject;
import br.com.filipe.brenner.controle.estudante.model.Teacher;

public class SubjectResponseDTO {

    private Long id;

    private String name;

    private String code;

    private Teacher teacher;

    private Float totalPoints;

    private Float minimumAverage;

    public SubjectResponseDTO(){
        // Construtor padrão
    }

    public SubjectResponseDTO(Subject subject) {
        id = subject.getId();
        name = subject.getName();
        code = subject.getCode();
        teacher = subject.getTeacher();
        totalPoints = subject.getTotalPoints();
        minimumAverage = subject.getMinimumAverage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
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
}
