package br.com.projetobhut.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Car {
	@Id
	private String _id;
	private String title;
	private String brand;
	private String price;
	private Integer age;
}
