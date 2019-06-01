package com.sourcecodeerror.service;

import java.util.List;

import com.sourcecodeerror.model.Acceso;
import com.sourcecodeerror.model.Adopcion;

public interface IAdopcionesService {
  
  public List<Adopcion> getListaAdopciones();

  public Adopcion getAdopcion(int adopcionId);

  public Adopcion createAdopcion(Adopcion newAdopcion);

  public boolean updateAdopcion(Adopcion updatedAdopcion);

  public boolean deleteAdopcion(int adopcionId);
}
