package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.PostDonacion;

public interface IPostsDonacionesRepo extends CrudRepository<PostDonacion, Integer>{

}
