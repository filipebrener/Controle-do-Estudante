package br.com.filipe.brener.controle.estudante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Subject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number_of_credits", nullable = false)
    private Integer numberOfCredits;

    @Column(name = "missed_classes", nullable = false)
    private Integer missedClasses;

    @ManyToOne    
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    public Subject(String name, Integer numberOfCredits, Integer missedClasses){
        this.name = name;
        this.numberOfCredits = numberOfCredits;
        this.missedClasses = missedClasses;
    }

    public Subject(){}

    public Integer getMissedClasses() {
        return missedClasses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(Integer numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public void setMissedClasses(Integer missedClasses) {
        this.missedClasses = missedClasses;
    }


}
