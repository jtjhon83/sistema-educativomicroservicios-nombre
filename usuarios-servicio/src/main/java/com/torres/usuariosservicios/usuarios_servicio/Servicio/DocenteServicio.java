package com.torres.usuariosservicios.usuarios_servicio.Servicio;

import com.torres.usuariosservicios.usuarios_servicio.Modelo.Docente;
import com.torres.usuariosservicios.usuarios_servicio.Repositorio.DocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicio {

    @Autowired
    private DocenteRepositorio docenteRepositorio;

    public List<Docente> listarDocentes() {
        return docenteRepositorio.findAll();
    }

    public Optional<Docente> obtenerDocentePorId(String id) {
        return docenteRepositorio.findById(id);
    }

    public Docente guardarDocente(Docente docente) {
        return docenteRepositorio.save(docente);
    }

    public void eliminarDocente(String id) {
        docenteRepositorio.deleteById(id);
    }

    // Puedes agregar más métodos según tus necesidades
}
