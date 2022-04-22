package br.com.filipe.brener.controle.estudante.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Activity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "content", nullable = true)
    private String content;
    
    @Column(name = "received_grade", nullable = true)
    private Float receivedGrade;
    
    @Column(name = "total_grade", nullable = true)
    private Float totalGrade;
    
    @Column(name = "notes", nullable = true)
    private String notes;

    public Activity(String title, LocalDateTime date, String content, Float receivedgrade, Float totalGrade, String notes) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.receivedGrade = receivedgrade;
        this.totalGrade = totalGrade;
        this.notes = notes;
    }

    public Activity(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Float getReceivedGrade() {
        return receivedGrade;
    }

    public void setReceivedGrade(Float receivedGrade) {
        this.receivedGrade = receivedGrade;
    }

    public Float getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Float totalGrade) {
        this.totalGrade = totalGrade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    @Override
    public String toString(){
        return "Atividade: " + this.id + "\nTitulo: " + this.title + "\nData: " + this.date;
    }

}
