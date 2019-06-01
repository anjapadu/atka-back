package com.sourcecodeerror.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.sourcecodeerror.model.Acceso;
import com.sourcecodeerror.repo.IAccesosRepo;

@Service
public class AccesosServiceImpl implements IAccesosService {

  @Autowired
  IAccesosRepo repo;

  @Override
  public List<Acceso> getListaAccesos() {
    return (List<Acceso>) repo.findAll();
  }

  @Override
  public Acceso getAcceso(String correo) {
    Optional<Acceso> result = repo.findById(correo);
    return result.isPresent() ? result.get() : null;
  }

  @Override
  public Acceso createAcceso(Acceso newAcceso) {
    return repo.save(newAcceso);
  }

  @Override
  public boolean validateAcceso(Acceso acceso) {
    Optional<Acceso> result = repo.findById(acceso.getCorreo());
    if (result.isPresent()) {
      if (result.get().getCorreo() == acceso.getCorreo() && result.get().getContrasena() == acceso.getContrasena()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean updateAcceso(Acceso updatedAcceso) {
    Optional<Acceso> result = repo.findById(updatedAcceso.getCorreo());
    if (result.isPresent()) {
      repo.save(updatedAcceso);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteAcceso(String accesoId) {
    Optional<Acceso> result = repo.findById(accesoId);
    if (result.isPresent()) {
      repo.deleteById(accesoId);
      return true;
    }
    return false;
  }

}
