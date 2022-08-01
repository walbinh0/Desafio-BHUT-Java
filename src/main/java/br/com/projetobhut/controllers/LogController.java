package br.com.projetobhut.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.projetobhut.entities.Log;
import br.com.projetobhut.helpers.DataFormat;
import br.com.projetobhut.repositories.ILogRepository;
import br.com.projetobhut.response.LogResponse;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@Controller
public class LogController {
	@Autowired
	ILogRepository logRepository;

	@ApiOperation("metodo para exibir o logs")
	@RequestMapping(value = "api/logs", method = RequestMethod.GET)
	public ResponseEntity<List<LogResponse>> getAll() {
		
		try {

			if (logRepository.findAll() != null) {

				List<Log> listaLog = new ArrayList<>();
				listaLog = logRepository.findAll();
				LogResponse logResponse;
				List<LogResponse> listaLogResponse = new ArrayList<>();

				for (Log log : listaLog) {
					logResponse = new LogResponse();
					logResponse.setId(log.getId());
					logResponse.setCar_id(log.getCar_id());
					logResponse.setStatus(log.getStatus());
					logResponse.setDataHora(DataFormat.DataParaString(log.getData_hora()));
					listaLogResponse.add(logResponse);
				}
				return ResponseEntity.status(HttpStatus.OK).body(listaLogResponse);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		
	} 

}
