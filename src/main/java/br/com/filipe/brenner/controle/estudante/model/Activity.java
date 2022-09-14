package br.com.filipe.brenner.controle.estudante.model;

import java.time.LocalDateTime;

public class Activity {

    private LocalDateTime time;

    private Float totalScore;

    private Float scoreReached;

    private Student student;

    private Subject subject;

    private String comments;

    private String local;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    public Float getScoreReached() {
        return scoreReached;
    }

    public void setScoreReached(Float scoreReached) {
        this.scoreReached = scoreReached;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
