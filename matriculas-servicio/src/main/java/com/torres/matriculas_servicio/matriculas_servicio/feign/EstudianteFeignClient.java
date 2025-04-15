package com.torres.matriculas_servicio.matriculas_servicio.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.torres.matriculas_servicio.matriculas_servicio.DTO.UsuarioEstudiante;


@FeignClient(name = "usuarios-servicio", url = "${usuarios-servicio.url}")// El nombre debe coincidir con el nombre de la aplicación del servicio usuarios
public interface EstudianteFeignClient {

    @GetMapping("/estudiantes/{id}")
    UsuarioEstudiante obtenerEstudiante(@PathVariable("id") String id);
}