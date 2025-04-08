package com.torres.matriculas_servicio.matriculas_servicio.DTO;

public class MatriculaRequest {
    private String estudianteId;
    private String asignaturaId;

    // Constructor vacío (necesario para la deserialización)
    public MatriculaRequest() {
    }
    //// Getters y setters

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

    
}
