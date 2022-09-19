package br.com.filipe.brenner.controle.estudante.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class BaseControllerTest {

    @Autowired
    protected WebTestClient testClient;

    protected final ObjectMapper objectMapper = new ObjectMapper();

    // TODO implementar métodos e adicionar recursos que sejam interessantes para testar os endpoints

}
