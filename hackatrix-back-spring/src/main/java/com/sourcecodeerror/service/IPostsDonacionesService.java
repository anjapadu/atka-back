package com.sourcecodeerror.service;

import java.util.List;

import com.sourcecodeerror.model.PostDonacion;

public interface IPostsDonacionesService {
  
  public List<PostDonacion> getListaPostsDonaciones();

  public PostDonacion getPostDonacion(int postDonacionId);

  public PostDonacion createPostDonacion(PostDonacion newPostDonacion);

  public boolean updatePostDonacion(PostDonacion updatedPostDonacion);

  public boolean deletePostDonacion(int postDonacionId);
}
