package com.fabrica.fabrica_de_galletas.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fabrica.fabrica_de_galletas.core.domain.Galleta;
import com.fabrica.fabrica_de_galletas.core.domain.Ingrediente;
import com.fabrica.fabrica_de_galletas.persistence.repository.GalletaRepository;
import com.fabrica.fabrica_de_galletas.persistence.repository.IngredienteRepository;

@Service

public class FabricaService {

    private final IngredienteRepository ingredienteRepository;
    private final GalletaRepository galletaRepository; 

    // INYECCION DE DEPENDENCIAS
    public FabricaService(IngredienteRepository ingredienteRepository, GalletaRepository galletaRepository) {
        this.ingredienteRepository = ingredienteRepository;
        this.galletaRepository = galletaRepository;
    }

    // METODO PARA OBTENER EL NUMERO TOTAL DE INGREDIENTES
    public long obtenerNumeroTotalIngredientes() {  
        return ingredienteRepository.count();
    }

    // METODO PARA OBTENER EL NUMERO TOTAL DE GALLETAS
    public long obtenerNumeroTotalGalletas() {  
        return galletaRepository.count();
    }

    //METODO PARA CREAR UNA GALLETA
    public Galleta crearGalleta(Galleta galleta) {
        return galletaRepository.save(galleta);
        
    }

    //METODO PARA ENLISTAR GALLETAS
    public List<Galleta> obtenerTodasLasGalletas() {
        return galletaRepository.findAll();
    }

    //METODO PARA BUSCAR GALLETA POR SABOR
    public List<Galleta> obtenerGalletasPorSabor(String sabor) {
        return galletaRepository.findBySabor(sabor);
    }

    //METODO PARA CREAR UN INGREDIENTE
    public Ingrediente crearIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }
    //METODO PARA ENLISTAR INGREDIENTES
    public List<Ingrediente> obtenerTodosLosIngredientes() {
        return ingredienteRepository.findAll();
    }

    //metodo actualizar galleta
    public Galleta actualizarGalleta(Long id, Galleta galletaActualizada) {
      return galletaRepository.findById(id).map(galleta -> {
              galleta.setNombre(galletaActualizada.getNombre());
              galleta.setPrecio(galletaActualizada.getPrecio());
              galleta.setSabor(galletaActualizada.getSabor());
              galleta.setGramaje(galletaActualizada.getGramaje());
              return galletaRepository.save(galleta);
          }) .orElseThrow(() -> new RuntimeException("Esa galleta con el id : " + id + " no existe mi papacho"));
    }

    // Metodo eliminar galleta
    public boolean eliminarGalleta(Long id) {
        if (!galletaRepository.existsById(id)) {
            throw new RuntimeException("Esa galleta con el id : " + id + " no existe mi papacho");
        }
        galletaRepository.deleteById(id);
        return true;
    }
    // Metodo eliminar ingrediente
    public boolean eliminarIngrediente(Long id) {
        if (!ingredienteRepository.existsById(id)) {
            throw new RuntimeException("Ese ingrediente con el id : " + id + " no existe mi papacho");
        }
        ingredienteRepository.deleteById(id);
        return true;
    }

    //metodo actualizar ingrediente
    public Ingrediente actualizarIngrediente(Long id, Ingrediente ingrediente) {
        if (!ingredienteRepository.existsById(id)) {
            throw new RuntimeException("Ese ingrediente con el id : " + id + " no existe mi papacho");
        }
        ingrediente.setId(id);
        return ingredienteRepository.save(ingrediente);
    }

}

    
    

   


