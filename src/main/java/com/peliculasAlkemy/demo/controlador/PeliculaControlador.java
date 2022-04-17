package com.peliculasAlkemy.demo.controlador;

import com.peliculasAlkemy.demo.dto.PeliculaDTO;
import com.peliculasAlkemy.demo.servicio.PeliculaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaControlador {

    @Autowired
    private PeliculaServicio peliculaServicio;

//------------------------------------------------------------------
    @GetMapping
    public List<PeliculaDTO> listarPeliculas(
            @RequestParam(value = "numeroDePaguina", defaultValue = "0", required = false) int numeroDePagina,
            @RequestParam(value = "tamañoDePagina", defaultValue = "10", required = false) int cantidadDePagina) {

        return peliculaServicio.obtenerTodasPeliculas(numeroDePagina,cantidadDePagina);
    }
//------------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> obtenerPublicacionPorId(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(peliculaServicio.obtenerPeliculaPorId(id));
    }
//------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<PeliculaDTO> guardarPelicula(@RequestBody PeliculaDTO peliculaDTO) {

        return new ResponseEntity<>(peliculaServicio.crearPelicula(peliculaDTO), HttpStatus.CREATED);
    }
//------------------------------------------------------------------

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> actualizarPelicula(@RequestBody PeliculaDTO peliculaDTO, @PathVariable(name = "id") long id) {

        PeliculaDTO peliculaRespuesta = peliculaServicio.actualizarPelicula(peliculaDTO, id);

        return new ResponseEntity<>(peliculaRespuesta, HttpStatus.OK);
    }
//------------------------------------------------------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") long id) {
        peliculaServicio.eliminarPelicula(id);
        return new ResponseEntity<>("Publicacion  eliminada con Exito", HttpStatus.OK);
    }

}
