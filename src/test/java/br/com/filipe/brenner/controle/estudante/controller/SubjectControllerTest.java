package br.com.filipe.brenner.controle.estudante.controller;

import br.com.filipe.brenner.controle.estudante.dto.http.ResponseWrapper;
import br.com.filipe.brenner.controle.estudante.dto.subject.CreateSubjectRequestDTO;
import br.com.filipe.brenner.controle.estudante.dto.subject.SubjectResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SubjectControllerTest extends BaseControllerTest{

    private final static String ENDPOINT = "/subject";

    @BeforeEach
    public void beforeEach(){
        createMasterUser();
    }

    @Test
    public void create(){

        CreateSubjectRequestDTO payload = new CreateSubjectRequestDTO();
        payload.setName("Programação");
        payload.setCode("SIN - 110");
        payload.setTotalPoints(100.0F);
        payload.setMinimumAverage(60.0F);

        // TODO adicionar autenticação do usuário e passar o token pelo header, também testar de autorização com falha

        var response =  this.testClient.post()
                .uri(ENDPOINT + "/create")
                .headers(httpHeaders -> httpHeaders.setBasicAuth(MASTER_NAME, MASTER_PASSWORD))
                .bodyValue(payload)
                .exchange()
                .expectBody(ResponseWrapper.class)
                .returnResult().getResponseBody();

        assertNotNull(response, "O endpoint não retornou nenhuma informação");
        assertEquals(201, response.getStatus());
        assertTrue(response.isSuccess());
        SubjectResponseDTO subject = objectMapper.convertValue(response.getData(), SubjectResponseDTO.class);
        assertEquals(payload.getCode(), subject.getCode(), "O código da disciplina está diferente do enviado");
        assertEquals(payload.getName(), subject.getName(), "O nome da disciplina está diferente do enviado");
        assertEquals(payload.getTotalPoints(), subject.getTotalPoints(), "O total de pontos da disciplina está diferente do enviado");
        assertEquals(payload.getMinimumAverage(), subject.getMinimumAverage(), "A média mínima está diferente da enviada");
    }

}
