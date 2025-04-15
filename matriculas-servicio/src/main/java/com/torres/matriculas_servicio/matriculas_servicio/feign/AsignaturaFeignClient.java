package com.torres.matriculas_servicio.matriculas_servicio.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.torres.matriculas_servicio.matriculas_servicio.DTO.AsignaturaDTO;



@FeignClient(name = "asignaturas-servicio", url = "${asignaturas-servicio.url}")
public interface AsignaturaFeignClient {

     @GetMapping("/asignaturas/{id}")

    AsignaturaDTO obtenerAsignatura(@PathVariable("id") String id);
}
