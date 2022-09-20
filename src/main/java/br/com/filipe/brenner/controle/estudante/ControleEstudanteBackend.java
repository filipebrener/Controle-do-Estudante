package br.com.filipe.brenner.controle.estudante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ControleEstudanteBackend {

	public static void main(String[] args) {
		SpringApplication.run(ControleEstudanteBackend.class, args);
		System.out.println("senha123" + new BCryptPasswordEncoder().encode("senha123"));
	}

}
