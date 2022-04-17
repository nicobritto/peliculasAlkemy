package com.peliculasAlkemy.demo.repositorio;

import com.peliculasAlkemy.demo.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {

}
