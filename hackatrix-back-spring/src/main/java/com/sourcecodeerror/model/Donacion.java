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
@Entity(name="Donaciones")
public class Donacion {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="Monto")
  private float monto;
  
  @ManyToOne
  @JoinColumn(name="Donante")
  private Persona persona;
  
  @ManyToOne
  @JoinColumn(name="Post")
  private PostDonacion postDonacion;
  
}
