package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.Organizacion;

public interface IOrganizacionesRepo extends CrudRepository<Organizacion, String> {

}
