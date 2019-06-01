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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="Adopciones")
public class Adopcion {
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="FechaPub")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date fechaPub;
  
  @Column(name="FechaAdop")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date fechaAdop;

  @ManyToOne
  @JoinColumn(name="Animal")
  private Animal animal;
  
  //Adoptante
  @ManyToOne
  @JoinColumn(name="PersonaAdopcion")
  private Persona personaAdopcion;
  
  //Ofertantes
  @ManyToOne
  @JoinColumn(name="PersonaOferta")
  private Persona personaOferta;
  
  @ManyToOne
  @JoinColumn(name="OrganizacionOferta")
  private Persona organizacionOferta;

  //Solicitudes de Adopcion
  @JsonIgnore
  @OneToMany(mappedBy = "adopcion")
  private List<SolicitudAdopcion> solicitudes;
  
  //Ubicacion
  @Column(name="LugarLatitud")
  private double lugarLat;
  
  @Column(name="LugarLongitud")
  private double lugarLong;
}
