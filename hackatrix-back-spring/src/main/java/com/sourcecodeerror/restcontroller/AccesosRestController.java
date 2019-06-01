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
import com.sourcecodeerror.service.AccesosServiceImpl;

@RestController
@RequestMapping("/api/v1.0/accesos")
public class AccesosRestController {
  @Autowired
  private AccesosServiceImpl service;

  @GetMapping
  public ResponseEntity<List<Acceso>> getListaAccesos() {
    List<Acceso> result = service.getListaAccesos();
    return new ResponseEntity<List<Acceso>>(result, HttpStatus.OK);
  }

  @GetMapping("/{accesoCorreo}")
  public ResponseEntity<Acceso> getAccesos(@PathVariable String accesoCorreo) {
    Acceso result = service.getAcceso(accesoCorreo);
    return new ResponseEntity<Acceso>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Object> validateAcceso(@RequestBody Acceso acceso) {
    boolean result = service.validateAcceso(acceso);
    return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/{accesoCorreo}")
  public ResponseEntity<Object> updateAcceso(@PathVariable String accesoCorreo, @RequestBody Acceso acceso) {
    acceso.setCorreo(accesoCorreo);
    boolean result = service.updateAcceso(acceso);
    return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/{accesoCorreo}")
  public ResponseEntity<Object> deleteAcceso(@PathVariable String accesoCorreo){
    boolean result = service.deleteAcceso(accesoCorreo);
    return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
