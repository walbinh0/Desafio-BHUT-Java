package br.com.projetobhut.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetobhut.entities.Log;

public interface ILogRepository extends MongoRepository<Log, String> {

}
