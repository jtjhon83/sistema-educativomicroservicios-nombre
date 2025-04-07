package com.torres.matriculas_servicio.matriculas_servicio.Controlador;

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

import com.torres.matriculas_servicio.matriculas_servicio.Modelo.Matricula;
import com.torres.matriculas_servicio.matriculas_servicio.Servicio.MatriculaServicio;

@RestController
@RequestMapping("/matriculas")
public class MatriculaControlador {
    @Autowired
    private MatriculaServicio matriculaServicio;

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

    @PostMapping
    public ResponseEntity<Matricula> crearMatricula(@RequestBody Matricula matricula) {
        Matricula nuevaMatricula = matriculaServicio.guardarMatricula(matricula);
        return new ResponseEntity<>(nuevaMatricula, HttpStatus.CREATED);
    }

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
