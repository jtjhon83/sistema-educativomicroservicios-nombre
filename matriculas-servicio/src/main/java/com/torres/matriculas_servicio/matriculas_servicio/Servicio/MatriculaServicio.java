package com.torres.matriculas_servicio.matriculas_servicio.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.matriculas_servicio.matriculas_servicio.DTO.AsignaturaDTO;
import com.torres.matriculas_servicio.matriculas_servicio.DTO.UsuarioEstudiante;
import com.torres.matriculas_servicio.matriculas_servicio.Modelo.Matricula;
import com.torres.matriculas_servicio.matriculas_servicio.Repositorio.MatriculaRepositorio;
import com.torres.matriculas_servicio.matriculas_servicio.feign.AsignaturaFeignClient;
import com.torres.matriculas_servicio.matriculas_servicio.feign.EstudianteFeignClient;

@Service //se crea anotacion de serviio 
public class MatriculaServicio {
    
    //se inyectan 
    @Autowired
    private MatriculaRepositorio matriculaRepositorio;
//se  inyecta las instancias de 
//Feign Clients utilizando la anotación @Autowired
     @Autowired
    private EstudianteFeignClient estudianteFeignClient;

    @Autowired
    private AsignaturaFeignClient asignaturaFeignClient;

    //otros metodos 

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
    //metodo 
     public Matricula crearNuevaMatricula(String estudianteId, String asignaturaId) {
        // Obtener la información del estudiante desde el servicio de usuarios
        UsuarioEstudiante estudiante = estudianteFeignClient.obtenerEstudiante(estudianteId);
        if (estudiante == null) {
            throw new RuntimeException("No se encontró el estudiante con ID: " + estudianteId);
        }

        // Obtener la información de la asignatura desde el servicio de asignaturas
        AsignaturaDTO asignatura = asignaturaFeignClient.obtenerAsignatura(asignaturaId);
        if (asignatura == null) {
            throw new RuntimeException("No se encontró la asignatura con ID: " + asignaturaId);
        }

        // Crear la entidad Matricula y guardarla en la base de datos
        Matricula nuevaMatricula = new Matricula();
        nuevaMatricula.setEstudianteId(estudianteId);
        nuevaMatricula.setAsignaturaId(asignaturaId);
        // Aquí podrías agregar más lógica si necesitas guardar más información de los DTOs en tu entidad Matricula

        return matriculaRepositorio.save(nuevaMatricula);
    }
}
