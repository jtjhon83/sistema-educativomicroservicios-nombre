package com.torres.usuariosservicios.usuarios_servicio.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.usuariosservicios.usuarios_servicio.Modelo.Estudiante;
import com.torres.usuariosservicios.usuarios_servicio.Repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicio {
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    public Optional<Estudiante> obtenerEstudiantePorId(String id) {
        return estudianteRepositorio.findById(id);
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }

    public void eliminarEstudiante(String id) {
        estudianteRepositorio.deleteById(id);
    }

    // Puedes agregar más métodos según tus necesidades
    
}
