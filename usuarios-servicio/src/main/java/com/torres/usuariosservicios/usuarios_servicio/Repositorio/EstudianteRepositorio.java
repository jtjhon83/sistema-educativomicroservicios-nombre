package com.torres.usuariosservicios.usuarios_servicio.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.torres.usuariosservicios.usuarios_servicio.Modelo.Estudiante;

public interface EstudianteRepositorio extends MongoRepository<Estudiante,String> {
    
}
