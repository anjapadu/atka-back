package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.DetalleCompra;

public interface IDetallesComprasRepo extends CrudRepository<DetalleCompra, Integer>{
  
}
