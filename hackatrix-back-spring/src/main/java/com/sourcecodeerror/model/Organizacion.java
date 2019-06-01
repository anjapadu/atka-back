package com.sourcecodeerror.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Organizaciones")
public class Organizacion {
  @Id
  @Column(name="RUC", length = 11)
  private String ruc;
  
  @Column(name="RazonSocial", length = 30)
  private String razonSocial;
  
  @Column (name="Descricion")
  private String desripcion;
  
  @Column(name="Direccion")
  private String direccion;
  
  @Column(name="Telefono",length = 9)
  private String telefono;
  
  @Column(name="Imagen")
  private String imagen;
  
  @Column (name="Estado")
  private int estado;
  
  @OneToOne
  @JoinColumn(name="Correo")
  private Acceso acceso; 
  
  @JsonIgnore
  @OneToMany(mappedBy = "organizacion")
  private List<Animal> animals;
  
  @JsonIgnore
  @OneToMany(mappedBy = "organizacion")
  private List<Producto> productos;
}
