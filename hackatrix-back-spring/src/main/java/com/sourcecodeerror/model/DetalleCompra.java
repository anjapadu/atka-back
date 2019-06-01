package com.sourcecodeerror.model;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="DetallesCompras")
public class DetalleCompra {
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @ManyToOne
  @JoinColumn(name="Compra")
  private Compra compra;
  
  @Column(name="Cantidad")
  private int cantidad;
  
  @Column(name="SubTotal")
  private float subTotal;
}
