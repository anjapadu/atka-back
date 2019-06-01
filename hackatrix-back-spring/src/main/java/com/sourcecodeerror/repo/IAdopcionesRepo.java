package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.Adopcion;

public interface IAdopcionesRepo extends CrudRepository<Adopcion, Integer>{
  
}
