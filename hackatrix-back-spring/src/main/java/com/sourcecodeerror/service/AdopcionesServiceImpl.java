package com.sourcecodeerror.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcecodeerror.model.Acceso;
import com.sourcecodeerror.model.Adopcion;
import com.sourcecodeerror.repo.IAccesosRepo;
import com.sourcecodeerror.repo.IAdopcionesRepo;

@Service
public class AdopcionesServiceImpl implements IAdopcionesService{

  @Autowired
  IAdopcionesRepo repo;

  @Override
  public List<Adopcion> getListaAdopciones() {
    return (List<Adopcion>) repo.findAll();
  }

  @Override
  public Adopcion getAdopcion(int adopcionId) {
    Optional<Adopcion> result = repo.findById(adopcionId);
    return result.isPresent() ? result.get() : null;
  }

  @Override
  public Adopcion createAdopcion(Adopcion newAdopcion) {
    return repo.save(newAdopcion);
  }


  @Override
  public boolean updateAdopcion(Adopcion updatedAdopcion) {
    Optional<Adopcion> result = repo.findById(updatedAdopcion.getId());
    if (result.isPresent()) {
      repo.save(updatedAdopcion);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteAdopcion(int adopcionId) {
    Optional<Adopcion> result = repo.findById(adopcionId);
    if (result.isPresent()) {
      repo.deleteById(adopcionId);
      return true;
    }
    return false;
  }


}
