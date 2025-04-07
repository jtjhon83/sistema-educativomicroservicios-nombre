package com.torres.usuariosservicios.usuarios_servicio.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torres.usuariosservicios.usuarios_servicio.Modelo.Estudiante;
import com.torres.usuariosservicios.usuarios_servicio.Servicio.EstudianteServicio;

@RestController
@RequestMapping("/estudiantes") // Define la ruta base para este controlador
public class EstudianteControlador {
    
     @Autowired
    private EstudianteServicio estudianteServicio;

    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        return ResponseEntity.ok(estudianteServicio.listarEstudiantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable String id) {
        Optional<Estudiante> estudiante = estudianteServicio.obtenerEstudiantePorId(id);
        return estudiante.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteServicio.guardarEstudiante(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable String id, @RequestBody Estudiante estudianteActualizado) {
        Optional<Estudiante> estudianteExistente = estudianteServicio.obtenerEstudiantePorId(id);

        if (estudianteExistente.isPresent()) {
            estudianteActualizado.setId(id); // Aseguramos que el ID del objeto actualizado sea el mismo que el de la ruta
            Estudiante estudianteActualizadoGuardado = estudianteServicio.guardarEstudiante(estudianteActualizado);
            return ResponseEntity.ok(estudianteActualizadoGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable String id) {
        if (estudianteServicio.obtenerEstudiantePorId(id).isPresent()) {
            estudianteServicio.eliminarEstudiante(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content si la eliminación fue exitosa
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 Not Found si el estudiante no existe
        }
    }
   

}
