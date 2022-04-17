package com.peliculasAlkemy.demo.dto;

public class PeliculaDTO {

    private Long id;
    private String titulo;
    private String calificacion;
    private String personajes;
    private String fechaCreacion;

    public PeliculaDTO() {
        super();
    }

    public PeliculaDTO(Long id, String titulo, String calificacion, String personajes, String fechaCreacion) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.personajes = personajes;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getPersonajes() {
        return personajes;
    }

    public void setPersonajes(String personajes) {
        this.personajes = personajes;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
