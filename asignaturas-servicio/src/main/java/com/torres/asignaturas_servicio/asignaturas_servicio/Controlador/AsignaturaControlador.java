package com.torres.asignaturas_servicio.asignaturas_servicio.Controlador;

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

import com.torres.asignaturas_servicio.asignaturas_servicio.Modelo.Asignatura;
import com.torres.asignaturas_servicio.asignaturas_servicio.Servicio.AsignaturaServicio;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaControlador {
    @Autowired
    private AsignaturaServicio asignaturaServicio;

    @GetMapping
    public ResponseEntity<List<Asignatura>> listarAsignaturas() {
        return ResponseEntity.ok(asignaturaServicio.listarAsignaturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerAsignaturaPorId(@PathVariable String id) {
        Optional<Asignatura> asignatura = asignaturaServicio.obtenerAsignaturaPorId(id);
        return asignatura.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asignatura> crearAsignatura(@RequestBody Asignatura asignatura) {
        Asignatura nuevaAsignatura = asignaturaServicio.guardarAsignatura(asignatura);
        return new ResponseEntity<>(nuevaAsignatura, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizarAsignatura(@PathVariable String id, @RequestBody Asignatura asignaturaActualizada) {
        Optional<Asignatura> asignaturaExistente = asignaturaServicio.obtenerAsignaturaPorId(id);

        if (asignaturaExistente.isPresent()) {
            asignaturaActualizada.setId(id);
            Asignatura asignaturaActualizadaGuardada = asignaturaServicio.guardarAsignatura(asignaturaActualizada);
            return ResponseEntity.ok(asignaturaActualizadaGuardada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable String id) {
        if (asignaturaServicio.obtenerAsignaturaPorId(id).isPresent()) {
            asignaturaServicio.eliminarAsignatura(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Nuevos endpoints para las búsquedas personalizadas
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Asignatura>> buscarPorNombre(@PathVariable String nombre) {
        List<Asignatura> asignaturas = asignaturaServicio.buscarAsignaturasPorNombre(nombre);
        if (asignaturas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asignaturas);
    }

    @GetMapping("/creditos/{creditos}")
    public ResponseEntity<List<Asignatura>> buscarPorCreditos(@PathVariable String creditos) {
        List<Asignatura> asignaturas = asignaturaServicio.buscarAsignaturasPorCreditos(creditos);
        if (asignaturas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asignaturas);
    }
    
}
