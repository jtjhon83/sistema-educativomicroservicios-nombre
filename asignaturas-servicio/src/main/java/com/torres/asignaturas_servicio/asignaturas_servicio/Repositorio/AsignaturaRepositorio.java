package com.torres.asignaturas_servicio.asignaturas_servicio.Repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.torres.asignaturas_servicio.asignaturas_servicio.Modelo.Asignatura;// Asegúrate de que la ruta al modelo Asignatura sea correcta

public interface AsignaturaRepositorio extends MongoRepository<Asignatura, String> {
    // Aquí puedes agregar métodos personalizados si los necesitas.
}
