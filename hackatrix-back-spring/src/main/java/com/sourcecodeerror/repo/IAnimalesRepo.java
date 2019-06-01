package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.Animal;

public interface IAnimalesRepo extends CrudRepository<Animal, Integer>{

}
