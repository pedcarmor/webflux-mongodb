package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "mensaje")
public class Mensaje {

	private String mensaje;
	
	@Id
	private String id;
}
