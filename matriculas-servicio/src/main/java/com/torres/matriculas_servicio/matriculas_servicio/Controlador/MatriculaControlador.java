package com.torres.matriculas_servicio.matriculas_servicio.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.torres.matriculas_servicio.matriculas_servicio.Modelo.Matricula;
import com.torres.matriculas_servicio.matriculas_servicio.Servicio.MatriculaServicio;

@RestController
@RequestMapping("/matriculas")
public class MatriculaControlador {
    @Autowired
    private MatriculaServicio matriculaServicio;

    @PostMapping
    public ResponseEntity<?> crearMatricula(
            @RequestParam String estudianteId,
            @RequestParam String asignaturaId) {
        try {
            Matricula nuevaMatricula = matriculaServicio.crearNuevaMatricula(estudianteId, asignaturaId);
            return new ResponseEntity<>(nuevaMatricula, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // Devolver mensaje de error
        }
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> listarMatriculas() {
        return ResponseEntity.ok(matriculaServicio.listarMatriculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtenerMatriculaPorId(@PathVariable String id) {
        Optional<Matricula> matricula = matriculaServicio.obtenerMatriculaPorId(id);
        return matricula.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar o refactorizar el otro método @PostMapping

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> actualizarMatricula(@PathVariable String id, @RequestBody Matricula matriculaActualizada) {
        Optional<Matricula> matriculaExistente = matriculaServicio.obtenerMatriculaPorId(id);

        if (matriculaExistente.isPresent()) {
            matriculaActualizada.setId(id);
            Matricula matriculaActualizadaGuardada = matriculaServicio.guardarMatricula(matriculaActualizada);
            return ResponseEntity.ok(matriculaActualizadaGuardada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatricula(@PathVariable String id) {
        if (matriculaServicio.obtenerMatriculaPorId(id).isPresent()) {
            matriculaServicio.eliminarMatricula(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
