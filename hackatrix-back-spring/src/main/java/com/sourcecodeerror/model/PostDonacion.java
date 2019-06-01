package com.sourcecodeerror.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
(name="Donaciones")
public class PostDonacion {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="Descripcion")
  private String descripcion;
  
  @Column(name="FechaPub")
  private Date fechaPub;
  
  @Column(name="FechaCierre")
  private Date fechaCierre;
  
  @Column(name="MontoSolicitado")
  private float montoSolicitado;
  
  @Column(name="MontoAcumulado")
  private float montoAcumulado;
  
  //Solicitantes
  @ManyToOne
  @JoinColumn(name="personaSolicitud")
  private Persona personaSolicitud;

  @ManyToOne
  @JoinColumn(name="organizacionSolicitud")
  private Organizacion organizacionSolicitud;
  
  //Ubicacion
  @Column(name="LugarLatitud")
  private double lugarLat;
  
  @Column(name="LugarLongitud")
  private double lugarLong;
  
  //Donaciones
  @JsonIgnore
  @OneToMany(mappedBy = "postDonacion")
  private List<Donacion> donaciones;
}
