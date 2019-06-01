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

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Animales")
public class Animal {
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="Nombre", length = 25)
  private String nombre;
  
  @Column(name="FechaNac")
  @Nullable
  private Date fechaNac;
  
  @Column (name="Raza",length = 30)
  private String raza;
  
  @Column (name="Color",length = 20)
  private String color;
  
  @Column (name = "Tamaño")
  private float tamaño;
  
  @Column(name = "Estado_Salud")
  private String estadoSalud;
  
  @Column(name="Descripcion")
  private String descripcion;
  
  @Column(name="Sexo", length = 1)
  private String sexo;
  
  @Column(name="Imagen")
  private String imagen;
  
  @Column (name="Estado")
  private int estado;
  
  //Creadores de Perfil
  @ManyToOne
  @JoinColumn(name="personaDni")
  private Persona persona;
  
  @ManyToOne
  @JoinColumn(name="organizacionRUC")
  private Organizacion organizacion;

  //Adopciones
  @JsonIgnore
  @OneToMany(mappedBy = "animal")
  private List<Adopcion> adopciones;
}
