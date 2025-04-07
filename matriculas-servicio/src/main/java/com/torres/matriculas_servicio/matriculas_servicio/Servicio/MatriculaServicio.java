package com.torres.matriculas_servicio.matriculas_servicio.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.torres.matriculas_servicio.matriculas_servicio.Modelo.Matricula;
import com.torres.matriculas_servicio.matriculas_servicio.Repositorio.MatriculaRepositorio;

public class MatriculaServicio {
    
    @Autowired
    private MatriculaRepositorio matriculaRepositorio;

    public List<Matricula> listarMatriculas() {
        return matriculaRepositorio.findAll();
    }

    public Optional<Matricula> obtenerMatriculaPorId(String id) {
        return matriculaRepositorio.findById(id);
    }

    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepositorio.save(matricula);
    }

    public void eliminarMatricula(String id) {
        matriculaRepositorio.deleteById(id);
    }
}
