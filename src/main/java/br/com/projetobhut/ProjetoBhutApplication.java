package br.com.projetobhut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ProjetoBhutApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBhutApplication.class, args);
	}

}
