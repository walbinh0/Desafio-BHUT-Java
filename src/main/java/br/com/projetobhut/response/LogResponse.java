package br.com.projetobhut.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class LogResponse {

	private String id;
	private String dataHora;
	private String car_id;
	private HttpStatus status;
	
	
}
