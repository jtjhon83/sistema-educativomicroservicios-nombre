package com.torres.asignaturas_servicio.asignaturas_servicio.Repositorio;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.torres.asignaturas_servicio.asignaturas_servicio.Modelo.Asignatura;// Asegúrate de que la ruta al modelo Asignatura sea correcta

public interface AsignaturaRepositorio extends MongoRepository<Asignatura, String> {
    // Aquí puedes agregar métodos personalizados si los necesitas.
    //Esto te permitirá realizar búsquedas de asignaturas por su nombre 
    //o por el número de créditos sin necesidad de escribir código adicional.
        List<Asignatura> findByNombre(String nombre);
        List<Asignatura> findByCreditos(String creditos);
    // También podrías usar @Query para consultas más complejas
}
