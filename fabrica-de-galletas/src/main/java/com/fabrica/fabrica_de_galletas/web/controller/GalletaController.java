package com.fabrica.fabrica_de_galletas.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.fabrica_de_galletas.business.service.FabricaService;
import com.fabrica.fabrica_de_galletas.core.domain.Galleta;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/galletas")
public class GalletaController {
    private final FabricaService fabricaService;

    //INYECCION DE DEPENDENCIAS
    public GalletaController(FabricaService fabricaService) {
        this.fabricaService = fabricaService;
    }

    //RUTA O ENDPOINT PARA CREAR GALLETA
    @PostMapping
    public ResponseEntity<Galleta> crearGalleta(@RequestBody Galleta galleta) {
        Galleta nuevGalleta = fabricaService.crearGalleta(galleta);
        return new ResponseEntity<>(nuevGalleta, HttpStatus.CREATED);
    }

    //RUTA PARA CONSULTAR/OBTENER GALLETAS
    
    @GetMapping("/{sabor}")
    public ResponseEntity<List<Galleta>> obtenerGalletasPorSabor(@PathVariable String sabor) {
        List<Galleta> galletas = fabricaService.obtenerGalletasPorSabor(sabor);
        if (galletas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(galletas, HttpStatus.OK);
}

//metodo para actualizar galletas/editar galletas   // put y patch para actualizar, post para crear, get para obtener y delete para eliminar
@PutMapping("/{id}")
public ResponseEntity<Galleta> actualizarGalleta(@PathVariable Long id, @RequestBody Galleta galletaActualizada) {
     try {
        Galleta galleta = fabricaService.actualizarGalleta(id, galletaActualizada);
        return new ResponseEntity<>(galleta, HttpStatus.OK);
     } catch (RuntimeException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}

//metodo para eliminar galletas
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarGalleta(@PathVariable Long id) {
    try {
        fabricaService.eliminarGalleta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

}
