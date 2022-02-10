package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mensaje;
import com.example.demo.interfaces.IMensajeRepository;
import reactor.core.publisher.Mono;

@RestController("")
public class AppController {

	
	@Autowired
	private IMensajeRepository repo;
	
	@GetMapping(value = "/add/{mensaje}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Mensaje> crear(@PathVariable("mensaje") String mensaje) {
		Mono<Mensaje> mensajes = repo.save(Mensaje.builder().mensaje(mensaje).build());
		return mensajes;
	}
	
}
