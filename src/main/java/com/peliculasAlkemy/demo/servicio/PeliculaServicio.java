package com.peliculasAlkemy.demo.servicio;

import com.peliculasAlkemy.demo.dto.PeliculaDTO;
import java.util.List;


public interface PeliculaServicio {

    public PeliculaDTO crearPelicula(PeliculaDTO peliculaDTO);
    
    public List<PeliculaDTO>obtenerTodasPeliculas(int numeroDePagina,int medidaDePagina);
    
    public PeliculaDTO obtenerPeliculaPorId(Long id);
    
    public PeliculaDTO actualizarPelicula(PeliculaDTO peliculaDTO,long id);

    public void eliminarPelicula(long id);
    
}
