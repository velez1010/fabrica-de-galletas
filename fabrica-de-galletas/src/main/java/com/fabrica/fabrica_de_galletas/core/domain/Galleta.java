package com.fabrica.fabrica_de_galletas.core.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Galleta {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String nombre;
   private String sabor;
   private double precio;
   private int gramaje;

   @ManyToMany
   private List<Ingrediente>ingredientes;

}
