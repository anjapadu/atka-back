package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.Producto;

public interface IProductosRepo extends CrudRepository<Producto, Integer>{

}
