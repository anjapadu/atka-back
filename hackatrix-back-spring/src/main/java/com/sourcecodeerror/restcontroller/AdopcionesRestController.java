package com.sourcecodeerror.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourcecodeerror.model.Acceso;
import com.sourcecodeerror.model.Adopcion;
import com.sourcecodeerror.service.AccesosServiceImpl;
import com.sourcecodeerror.service.AdopcionesServiceImpl;

@RestController
@RequestMapping("/api/v1.0/adopciones")
public class AdopcionesRestController {
  @Autowired
  private AdopcionesServiceImpl service;

  @GetMapping
  public ResponseEntity<List<Adopcion>> getListaAdopciones() {
    List<Adopcion> result = service.getListaAdopciones();
    return new ResponseEntity<List<Adopcion>>(result, HttpStatus.OK);
  }

  @GetMapping("/{adopcionId}")
  public ResponseEntity<Adopcion> getAdopcion(@PathVariable int adopcionId) {
    Adopcion result = service.getAdopcion(adopcionId);
    return new ResponseEntity<Adopcion>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Adopcion> createAdopcion(@RequestBody Adopcion newAdopcion) {
    Adopcion result =  service.createAdopcion(newAdopcion);
    return new ResponseEntity<Adopcion> (result, HttpStatus.OK);
  }
  
  @PostMapping("/{adopcionId}")
  public ResponseEntity<Object> updateAdopcion(@PathVariable int adopcionId, @RequestBody Adopcion adopcion) {
    adopcion.setId(adopcionId);
    boolean result = service.updateAdopcion(adopcion);
    return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/{adopcionId}")
  public ResponseEntity<Object> deleteAdopcion(@PathVariable int adopcionId){
    boolean result = service.deleteAdopcion(adopcionId);
    return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
