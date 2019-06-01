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

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Productos")
public class Producto {
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="Categoria")
  private String categoria;
  
  @Column(name="Nombre")
  private String nombre;
  
  @Column(name="Descripcion")
  private String descripcion;
  
  @Column(name="Precio")
  private float precio;
  
  @Column(name="Imagen")
  private String imagen;
  
  @Column(name="Estado")
  private int estado;
  
  @ManyToOne
  @JoinColumn(name="OrganizacionRUC")
  private Organizacion organizacion;
}
