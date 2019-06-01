package com.sourcecodeerror.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Personas")
public class Persona {
  @Id
  @Column(name="DNI", length = 8)
  private String dni;
  
  @Column(name="Nombre", length = 25)
  private String nombre;
  
  @Column (name="Apellido",length = 25)
  private String apellido;
  
  @Column(name="FechaNac")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date fechaNac;
  
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
  
  //Perfiles de Animales
  @JsonIgnore
  @OneToMany(mappedBy = "persona")
  private List<Animal> animals;

  //Compras
  @JsonIgnore
  @OneToMany(mappedBy = "personaCompra")
  private List<Compra> compras;
  
  //Adopciones
  @JsonIgnore
  @OneToMany(mappedBy = "personaOferta")
  private List<Adopcion> adopcionesPub;

  @JsonIgnore
  @OneToMany(mappedBy = "personaAdopcion")
  private List<Adopcion> adopciones;
  
  //Solicitudes de Adopcion
  @JsonIgnore
  @OneToMany(mappedBy = "persona")
  private List<SolicitudAdopcion> solicitudesAdop;
  
  //Donaciones
  @JsonIgnore
  @OneToMany(mappedBy = "persona")
  private List<Donacion> donaciones;
  
  
}