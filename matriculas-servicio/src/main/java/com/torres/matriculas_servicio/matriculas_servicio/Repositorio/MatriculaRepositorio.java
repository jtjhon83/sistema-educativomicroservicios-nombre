package com.torres.matriculas_servicio.matriculas_servicio.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.torres.matriculas_servicio.matriculas_servicio.Modelo.Matricula;

public interface MatriculaRepositorio extends MongoRepository<Matricula, String > {
    
}
