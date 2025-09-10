package com.fabrica.fabrica_de_galletas.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.fabrica_de_galletas.business.service.FabricaService;
import com.fabrica.fabrica_de_galletas.core.domain.Ingrediente;

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
@RequestMapping("/api/ingredientes")
public class IngredienteController {
    private final FabricaService fabricaService;

    //INYECCION DE DEPENDENCIAS
    public IngredienteController(FabricaService fabricaService) {
        this.fabricaService = fabricaService;
    }

    //RUTA O ENDPOINT PARA CREAR INGREDIENTE
    @PostMapping
    public ResponseEntity<Ingrediente> crearIngrediente(@RequestBody Ingrediente ingrediente) {
        Ingrediente nuevoIngrediente = fabricaService.crearIngrediente(ingrediente);
        return new ResponseEntity<>(nuevoIngrediente, HttpStatus.CREATED);
    }

    //RUTA PARA CONSULTAR/OBTENER INGREDIENTES

    @GetMapping
    public ResponseEntity<List<Ingrediente>> obtenerTodosLosIngredientes() {
        List<Ingrediente> ingredientes = fabricaService.obtenerTodosLosIngredientes();
        if (ingredientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ingredientes, HttpStatus.OK);
    }

    //metodo para actualizar/ editar los ingredientes
    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> actualizarIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        Ingrediente ingredienteActualizado = fabricaService.actualizarIngrediente(id, ingrediente);
        if (ingredienteActualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ingredienteActualizado, HttpStatus.OK);
    }

    //metodo para eliminar ingredientes
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIngrediente(@PathVariable Long id) {
        boolean eliminado = false;
        //boolean eliminado = fabricaService.eliminarIngrediente(id);
        if (!eliminado) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}