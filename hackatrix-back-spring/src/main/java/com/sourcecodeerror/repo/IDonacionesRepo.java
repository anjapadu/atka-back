package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.Donacion;

public interface IDonacionesRepo extends CrudRepository<Donacion, Integer>{

}
