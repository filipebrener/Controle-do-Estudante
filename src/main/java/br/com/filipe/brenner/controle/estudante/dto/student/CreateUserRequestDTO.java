package br.com.filipe.brenner.controle.estudante.dto.student;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = "true")
public class CreateUserRequestDTO {

    private String name;

    private String username;

    private String password;

    private String email;

    private String celPhoneNumber;

    public CreateUserRequestDTO() {
    }

    public CreateUserRequestDTO(String name, String username, String password, String email, String celPhoneNumber) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.celPhoneNumber = celPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelPhoneNumber() {
        return celPhoneNumber;
    }

    public void setCelPhoneNumber(String celPhoneNumber) {
        this.celPhoneNumber = celPhoneNumber;
    }
}
