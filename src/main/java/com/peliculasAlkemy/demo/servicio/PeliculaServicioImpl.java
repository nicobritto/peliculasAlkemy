package com.peliculasAlkemy.demo.servicio;

import com.peliculasAlkemy.demo.dto.PeliculaDTO;
import com.peliculasAlkemy.demo.entidades.Pelicula;
import com.peliculasAlkemy.demo.excepciones.ResourseNotFoundException;
import com.peliculasAlkemy.demo.repositorio.PeliculaRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServicioImpl implements PeliculaServicio {

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    @Override
    public PeliculaDTO crearPelicula(PeliculaDTO peliculaDTO) {

        Pelicula pelicula = mapearEntidad(peliculaDTO);

        Pelicula nuevaPelicula = peliculaRepositorio.save(pelicula);

        PeliculaDTO pelicularespuesta = mapearDTO(nuevaPelicula);

        return pelicularespuesta;
    }
//----------------------------------------------------------------------------------

    @Override
    public List<PeliculaDTO> obtenerTodasPeliculas(int numeroDePagina,int medidaDePagina) {
        Pageable pageable=PageRequest.of(numeroDePagina, medidaDePagina);
        //Pageable paginable
        
        Page<Pelicula>peliculas=peliculaRepositorio.findAll(pageable);

        List<Pelicula> listaDepeliculas = peliculas.getContent();
        return listaDepeliculas.stream().map(pelicula -> mapearDTO(pelicula)).collect(Collectors.toList());

    }

    //-------------------------------------------------------------------------------
    //convierte  entidad a DTO
    private PeliculaDTO mapearDTO(Pelicula pelicula) {

        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(pelicula.getId());
        peliculaDTO.setTitulo(pelicula.getTitulo());
        peliculaDTO.setFechaCreacion(pelicula.getFechaCreacion());
        peliculaDTO.setPersonajes(pelicula.getPersonajes());
        peliculaDTO.setCalificacion(pelicula.getCalificacion());

        return peliculaDTO;
    }

    //convierte de DTO a entidad
    private Pelicula mapearEntidad(PeliculaDTO peliculaDTO) {

        Pelicula pelicula = new Pelicula();
        pelicula.setId(peliculaDTO.getId());
        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setFechaCreacion(peliculaDTO.getFechaCreacion());
        pelicula.setPersonajes(peliculaDTO.getPersonajes());
        pelicula.setCalificacion(peliculaDTO.getCalificacion());
        return pelicula;

    }//---------------------------------------------------------------------------------

    @Override
    public PeliculaDTO obtenerPeliculaPorId(Long id) {
        Pelicula pelicula = peliculaRepositorio.findById(id).orElseThrow(() -> new ResourseNotFoundException("pelicula", "id", id));

        return mapearDTO(pelicula);

    }//----------------------------------------------------------------------------

    @Override
    public PeliculaDTO actualizarPelicula(PeliculaDTO peliculaDTO, long id) {
        Pelicula pelicula = peliculaRepositorio.findById(id).orElseThrow(() -> new ResourseNotFoundException("pelicula", "id", id));

        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setFechaCreacion(peliculaDTO.getFechaCreacion());
        pelicula.setPersonajes(peliculaDTO.getPersonajes());
        pelicula.setCalificacion(peliculaDTO.getCalificacion());

        Pelicula peliculaActualizada = peliculaRepositorio.save(pelicula);

        return mapearDTO(peliculaActualizada);

    }
//------------------------------------------------------------------------

    @Override
    public void eliminarPelicula(long id) {
        Pelicula pelicula = peliculaRepositorio.findById(id).orElseThrow(() -> new ResourseNotFoundException("pelicula", "id", id));

        peliculaRepositorio.delete(pelicula);
         
    }

}
