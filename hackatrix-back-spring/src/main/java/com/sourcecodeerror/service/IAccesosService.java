package com.sourcecodeerror.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sourcecodeerror.model.Acceso;

public interface IAccesosService {
  
  public List<Acceso> getListaAccesos();
  public Acceso getAcceso(String correo);
  
  public Acceso createAcceso(Acceso newAcceso);
  
  public boolean validateAcceso(Acceso acceso);
  public boolean updateAcceso(Acceso updatedAcceso);
  
  public boolean deleteAcceso(String accesoId);

}
