package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mensaje;
import com.example.demo.interfaces.IMensajeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("")
public class AppController {
	
	@Autowired
	private IMensajeRepository repo;
	
	@GetMapping(value = "/get", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Mensaje> recogerTodo() {
		Flux<Mensaje> mensajes = repo.findAll();
		return mensajes;
	}
	
	@GetMapping(value = "/get/{id}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Mensaje> recogerUno(@PathVariable("ind") String id){
		Mono<Mensaje> mensaje = repo.findById(id);
		return mensaje;
	}
}
