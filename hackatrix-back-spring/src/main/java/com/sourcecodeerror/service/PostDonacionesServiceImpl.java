package com.sourcecodeerror.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcecodeerror.model.Adopcion;
import com.sourcecodeerror.model.PostDonacion;
import com.sourcecodeerror.repo.IAdopcionesRepo;
import com.sourcecodeerror.repo.IPostsDonacionesRepo;

@Service
public class PostDonacionesServiceImpl implements IPostsDonacionesService {

  @Autowired
  IPostsDonacionesRepo repo;

  @Override
  public List<PostDonacion> getListaPostsDonaciones() {
    return (List<PostDonacion>) repo.findAll();
  }

  @Override
  public PostDonacion getPostDonacion(int postDonacionId) {
    Optional<PostDonacion> result = repo.findById(postDonacionId);
    return result.isPresent() ? result.get() : null;
  }

  @Override
  public PostDonacion createPostDonacion(PostDonacion newPostDonacion) {
    return repo.save(newPostDonacion);
  }

  @Override
  public boolean updatePostDonacion(PostDonacion updatedPostDonacion) {
    Optional<PostDonacion> result = repo.findById(updatedPostDonacion.getId());
    if (result.isPresent()) {
      repo.save(updatedPostDonacion);
      return true;
    }
    return false;
  }

  @Override
  public boolean deletePostDonacion(int postDonacionId) {
    Optional<PostDonacion> result = repo.findById(postDonacionId);
    if (result.isPresent()) {
      repo.deleteById(postDonacionId);
      return true;
    }
    return false;
  }
}
