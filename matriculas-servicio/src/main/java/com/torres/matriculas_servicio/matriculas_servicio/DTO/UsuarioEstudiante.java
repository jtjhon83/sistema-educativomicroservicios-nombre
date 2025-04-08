package com.torres.matriculas_servicio.matriculas_servicio.DTO;

public class UsuarioEstudiante {
    
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String cedula;
     // Constructor vacío (necesario para la deserialización)
     public UsuarioEstudiante() {
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
     public String getApellido() {
         return apellido;
     }
     public void setApellido(String apellido) {
         this.apellido = apellido;
     }
     public String getCorreo() {
         return correo;
     }
     public void setCorreo(String correo) {
         this.correo = correo;
     }
     public String getCedula() {
         return cedula;
     }
     public void setCedula(String cedula) {
         this.cedula = cedula;
     }
     // Puedes añadir más atributos y sus respectivos getters y setters si es necesario

    
}
