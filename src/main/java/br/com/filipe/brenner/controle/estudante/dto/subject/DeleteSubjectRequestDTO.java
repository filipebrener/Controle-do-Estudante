package br.com.filipe.brenner.controle.estudante.dto.subject;


import br.com.filipe.brenner.controle.estudante.model.UserModel;

public class DeleteSubjectRequestDTO {

    private Long id;

    private String name;

    private String code;

    private UserModel teacher;

    private Float totalPoints;

    private Float minimumAverage;

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

    public UserModel getUserModel() {
        return teacher;
    }

    public void setUserModel(UserModel teacher) {
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
        return String.format("%s - %s", this.code, this.name);
    }
}
