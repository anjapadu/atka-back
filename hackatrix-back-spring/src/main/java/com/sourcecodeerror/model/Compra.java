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
@Entity(name="Compras")
public class Compra {
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;
  
  @Column(name="FechaSolicitud")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date fechaSolicitado;
  
  @Column(name="FechaAceptacion")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy@HH:mm:ss", timezone = "America/Bogota")
  private Date fechaAceptado;
  
  @Column(name="FechaEntrega")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy@HH:mm:ss", timezone = "America/Bogota")
  private Date fechaEntregado;
  
  @Column(name="TotalCompra")
  private float totalCompra;
  
  @ManyToOne
  @JoinColumn(name="personaCompra")
  private Organizacion personaCompra;
  
  @ManyToOne
  @JoinColumn(name="organizacionCompra")
  private Organizacion organizacionCompra;
  
  @ManyToOne
  @JoinColumn(name="organizacionOferta")
  private Organizacion organizacionOferta;
  
  @Column(name="Estado")
  private int estado;
  
  //Detalles Compra
  @JsonIgnore
  @OneToMany(mappedBy = "compra")
  private List<DetalleCompra> detalles;
  
  

}
