package br.com.projetobhut.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
@Document
public class Log {
	@Id
	private String id;
	@CreatedDate
	private Date data_hora;
	private String car_id;
	private HttpStatus status;
	
}
