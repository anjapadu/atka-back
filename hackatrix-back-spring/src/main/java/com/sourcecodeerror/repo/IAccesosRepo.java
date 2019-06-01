package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import com.sourcecodeerror.model.Acceso;

public interface IAccesosRepo extends CrudRepository<Acceso, String>{
  
  public Optional<Acceso> findByCorreo(String correo);
}