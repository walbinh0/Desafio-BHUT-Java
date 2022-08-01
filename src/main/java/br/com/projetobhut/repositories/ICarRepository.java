package br.com.projetobhut.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetobhut.entities.Car;

public interface ICarRepository extends MongoRepository<Car, String> {

}
