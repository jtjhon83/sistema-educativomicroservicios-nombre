package com.torres.matriculas_servicio.matriculas_servicio.Modelo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matriculas")
public class Matricula {

    @Id
    private String id;

    private String estudianteId; // ID del estudiante del servicio usuarios-servicio
    private String asignaturaId; // ID de la asignatura del servicio asignaturas-servicio

    private LocalDateTime fechaMatricula;
    private String calificacion;

    public Matricula() {
        this.fechaMatricula = LocalDateTime.now();
    }

    public Matricula(String estudianteId, String asignaturaId) {
        this.estudianteId = estudianteId;
        this.asignaturaId = asignaturaId;
        this.fechaMatricula = LocalDateTime.now();
    }
    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(String asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public LocalDateTime getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDateTime fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
