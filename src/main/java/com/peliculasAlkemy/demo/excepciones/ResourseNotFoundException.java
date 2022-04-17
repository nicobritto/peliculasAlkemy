package com.peliculasAlkemy.demo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//le ponemos ResponseStatus(value = HttpStatus.NOT_FOUND)
// que el valor q va dar cuando llamemos a esta clase(ResourseNotFoundException)  es un no encontrado 
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourseNotFoundException extends RuntimeException {
    //recurso no encontrado ResourseNotFoundException

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private Long valorDelCampo;

    public ResourseNotFoundException(String nombreDelRecurso, String nombreDelCampo, Long valorDelCampo) {
        super(String.format("%s no  encontradA con : %s : '%s'", nombreDelRecurso, nombreDelRecurso, nombreDelRecurso));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    public Long getValorDelCampo() {
        return valorDelCampo;
    }

    public void setValorDelCampo(Long valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }

}
