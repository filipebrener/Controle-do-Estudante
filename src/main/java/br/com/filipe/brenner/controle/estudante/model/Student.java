package br.com.filipe.brenner.controle.estudante.model;

public class Student {

    private String name;

    private String password;

    private String email;

    private String phoneNumber;

    // TODO Verificar melhor forma de armazenar o ícone
//    private Blob icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
