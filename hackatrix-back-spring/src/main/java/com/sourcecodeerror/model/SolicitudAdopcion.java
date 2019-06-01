package com.sourcecodeerror.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="SolicitudesAdopciones")
public class SolicitudAdopcion {
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;
  
  @ManyToOne
  @JoinColumn(name="Adopcion")
  public Adopcion adopcion;
  
  @ManyToOne
  @JoinColumn(name="Persona")
  private Persona persona;
  
  @Column(name="Estado")
  private int estado;
}
