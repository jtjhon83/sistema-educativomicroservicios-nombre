package com.torres.asignaturas_servicio.asignaturas_servicio.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.asignaturas_servicio.asignaturas_servicio.Modelo.Asignatura;
import com.torres.asignaturas_servicio.asignaturas_servicio.Repositorio.AsignaturaRepositorio;

@Service
public class AsignaturaServicio {
    
     @Autowired
    private AsignaturaRepositorio asignaturaRepositorio;

    public List<Asignatura> listarAsignaturas() {
        return asignaturaRepositorio.findAll();
    }

    public Optional<Asignatura> obtenerAsignaturaPorId(String id) {
        return asignaturaRepositorio.findById(id);
    }

    public Asignatura guardarAsignatura(Asignatura asignatura) {
        return asignaturaRepositorio.save(asignatura);
    }

    public void eliminarAsignatura(String id) {
        asignaturaRepositorio.deleteById(id);
    }

}
