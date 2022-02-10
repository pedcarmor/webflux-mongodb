package com.example.demo.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Mensaje;

@Repository
public interface IMensajeRepository extends ReactiveMongoRepository<Mensaje, String>{
	

}
