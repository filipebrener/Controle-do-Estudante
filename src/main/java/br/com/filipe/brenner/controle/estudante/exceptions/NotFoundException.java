package br.com.filipe.brenner.controle.estudante.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Class<?> c, Long id){
        super(String.format("Não foi possível encontrar um registro da entidade %s com o id: %d", c.getSimpleName(), id));
    }
}
