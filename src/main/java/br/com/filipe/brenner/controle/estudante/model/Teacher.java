package br.com.filipe.brenner.controle.estudante.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher extends UserModel {

    private String name;

    private String email;

    @OneToMany
    @JoinTable(name="teacher_subject",
            joinColumns={@JoinColumn(name="teacher_id",
            referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="subject_id",
            referencedColumnName="id")})
    private List<Subject> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
