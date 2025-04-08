package com.torres.matriculas_servicio.matriculas_servicio.DTO;

public class AsignaturaDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private String creditos;

    // Constructor vacío (necesario para la deserialización)
    public AsignaturaDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }
    
}
