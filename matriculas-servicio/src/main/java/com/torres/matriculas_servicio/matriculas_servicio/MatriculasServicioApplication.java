package com.torres.matriculas_servicio.matriculas_servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // tu microservicio matriculas-servicio está habilitado para utilizar Feign Clients. Con esta anotacion y las dependencias añaddidas 
@SpringBootApplication
public class MatriculasServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatriculasServicioApplication.class, args);
	}

}
