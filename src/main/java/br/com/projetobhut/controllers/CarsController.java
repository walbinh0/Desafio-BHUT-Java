package br.com.projetobhut.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import br.com.projetobhut.entities.Car;
import br.com.projetobhut.entities.Log;
import br.com.projetobhut.repositories.ICarRepository;
import br.com.projetobhut.repositories.ILogRepository;
import br.com.projetobhut.request.CarRequest;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
public class CarsController {
	Queue<Car> filaCar = new LinkedList<>();
	@Autowired
	ICarRepository carRepository;
	@Autowired
	ILogRepository logRepository;

	@ApiOperation("Metodo Que esta consumindo a api externa e retornando a lista de carros dela")
	@RequestMapping(value = "api/listCars", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll() {
		try {
			final String url = "http://api-test.bhut.com.br:3000/api/Cars";

			RestTemplate restTemplate = new RestTemplate();
			Object[] cars = restTemplate.getForObject(url, Object[].class);

			if (cars.length < 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}

			return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(cars));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
@ApiOperation("Metodo que esta consumindo uma api extarna E cadastrando car nela")
	@RequestMapping(value = "api/createCar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Car> Post(@RequestBody CarRequest carRequest) {
		try {
			final String url = "http://api-test.bhut.com.br:3000/api/Cars";

			Car car;
			Log log;

			if (carRequest != null) {
				car = new Car();
				car.setAge(carRequest.getAge());
				car.setBrand(carRequest.getBrand());
				car.setPrice(carRequest.getPrice());
				car.setTitle(carRequest.getTitle());
				carRepository.save(car);

				if (filaCar.add(car)) {
					// implementar o webhook
				}

				RestTemplate restTemplate = new RestTemplate();

				car = restTemplate.postForEntity(url, car, Car.class).getBody();

				log = new Log();
				log.setCar_id(car.get_id());
				log.setStatus(HttpStatus.OK);
				logRepository.save(log);

			} else {
				log = new Log();
				log.setCar_id(null);
				log.setStatus(HttpStatus.BAD_REQUEST);
				logRepository.save(log);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}

			return ResponseEntity.status(HttpStatus.OK).body(car);
			
		} catch (Exception e) {
			Log log = new Log();
			log.setCar_id(null);
			log.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			logRepository.save(log);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
