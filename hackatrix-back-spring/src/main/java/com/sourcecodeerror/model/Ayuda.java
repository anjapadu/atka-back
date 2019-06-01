package com.sourcecodeerror.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Ayuda {
  private List<PostDonacion> postsDonaciones;
  private List<Adopcion> adopciones;
}
