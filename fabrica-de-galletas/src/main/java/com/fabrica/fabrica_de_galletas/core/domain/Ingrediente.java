package com.fabrica.fabrica_de_galletas.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Ingrediente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private long id;
   public String nombre;
   private double costo;

}
