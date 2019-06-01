package com.sourcecodeerror.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourcecodeerror.model.Ayuda;
import com.sourcecodeerror.service.AdopcionesServiceImpl;
import com.sourcecodeerror.service.PostDonacionesServiceImpl;

@RestController
@RequestMapping("/api/v1.0/ayudas")
public class AyudasRestController {
  @Autowired
  private PostDonacionesServiceImpl servicePostDon;
  @Autowired
  private AdopcionesServiceImpl serviceAdop;
  
  @GetMapping()
  public ResponseEntity<Ayuda> getListaAyudas(){
    Ayuda result = new Ayuda();
    result.setPostsDonaciones(servicePostDon.getListaPostsDonaciones());
    result.setAdopciones(serviceAdop.getListaAdopciones());
    return new ResponseEntity<Ayuda>(result,HttpStatus.OK);
  }
}
