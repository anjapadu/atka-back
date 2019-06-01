package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.Persona;

public interface IPersonasRepo extends CrudRepository<Persona, String>{

}
