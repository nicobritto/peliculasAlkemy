package com.peliculasAlkemy.demo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pelicula", uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})})
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false) 
    private String titulo;

    @Column(name = "calificacion", nullable = false)
    private String calificacion;

    @Column(name = "personajes", nullable = false)
    private String personajes;

    @Column(name = "fechaCreacion", nullable = false)
    private String fechaCreacion;

    public Pelicula(Long id, String titulo, String calificacion, String personajes, String fechaCreacion) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.personajes = personajes;
        this.fechaCreacion = fechaCreacion;
    }

    public Pelicula() {
        super();
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
