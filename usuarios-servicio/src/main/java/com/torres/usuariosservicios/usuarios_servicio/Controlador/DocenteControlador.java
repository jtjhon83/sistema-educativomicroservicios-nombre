package com.torres.usuariosservicios.usuarios_servicio.Controlador;

import com.torres.usuariosservicios.usuarios_servicio.Modelo.Docente;
import com.torres.usuariosservicios.usuarios_servicio.Servicio.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/docentes") // Define la ruta base para este controlador
public class DocenteControlador {

    @Autowired
    private DocenteServicio docenteServicio;

    @GetMapping
    public ResponseEntity<List<Docente>> listarDocentes() {
        return ResponseEntity.ok(docenteServicio.listarDocentes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> obtenerDocentePorId(@PathVariable String id) {
        Optional<Docente> docente = docenteServicio.obtenerDocentePorId(id);
        return docente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Docente> crearDocente(@RequestBody Docente docente) {
        Docente nuevoDocente = docenteServicio.guardarDocente(docente);
        return new ResponseEntity<>(nuevoDocente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docente> actualizarDocente(@PathVariable String id, @RequestBody Docente docenteActualizado) {
        Optional<Docente> docenteExistente = docenteServicio.obtenerDocentePorId(id);

        if (docenteExistente.isPresent()) {
            docenteActualizado.setId(id); // Aseguramos que el ID del objeto actualizado sea el mismo que el de la ruta
            Docente docenteActualizadoGuardado = docenteServicio.guardarDocente(docenteActualizado);
            return ResponseEntity.ok(docenteActualizadoGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable String id) {
        if (docenteServicio.obtenerDocentePorId(id).isPresent()) {
            docenteServicio.eliminarDocente(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content si la eliminación fue exitosa
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 Not Found si el docente no existe
        }
    }
}
