package br.com.filipe.brenner.controle.estudante.model.Enum;

public enum DayOfWeek {

    MONDAY("Segunda-feira"),
    TUESDAY("Terça-feira"),
    WEDNESDAY("Quarta-feira"),
    THURSDAY("Quinta-feira"),
    FRIDAY("Sexta-feira"),
    SATURDAY("Sábado"),
    SUNDAY("Domingo");

    private String name;

    DayOfWeek(String name){
        this.name = name;
    }

}
