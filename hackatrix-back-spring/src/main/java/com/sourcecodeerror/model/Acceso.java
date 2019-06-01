package com.sourcecodeerror.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Accesos")
public class Acceso {
  @Id
  @Column(name="Correo")
  private String correo;
  
  @Column(name="Contrasena")
  private String contrasena;
  
  @Column(name="TipoCuenta")
  private String tipoCuenta;
}
