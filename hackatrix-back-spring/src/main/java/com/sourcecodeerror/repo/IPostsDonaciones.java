package com.sourcecodeerror.repo;

import org.springframework.data.repository.CrudRepository;

import com.sourcecodeerror.model.PostDonacion;

public interface IPostsDonaciones extends CrudRepository<PostDonacion, Integer>{

}
