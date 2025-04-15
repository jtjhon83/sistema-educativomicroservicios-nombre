package com.torres.usuariosservicios.usuarios_servicio.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.torres.usuariosservicios.usuarios_servicio.Modelo.Docente;

public interface DocenteRepositorio extends MongoRepository<Docente,String> {
    
}
