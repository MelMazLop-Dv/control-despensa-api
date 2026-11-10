package com.estudiante.despensa.controller;

import com.estudiante.despensa.modelo.Producto;
import com.estudiante.despensa.modelo.ResumenInventario;
import com.estudiante.despensa.service.DespensaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private DespensaService despensaService;


    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        List<Producto> productos = despensaService.obtenerTodos();
        return ResponseEntity.ok(productos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        Producto producto = despensaService.obtenerPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Producto>> obtenerPorCategoria(@PathVariable String categoria) {
        List<Producto> productos = despensaService.obtenerPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }


    @GetMapping("/stock-bajo")
    public ResponseEntity<List<Producto>> obtenerStockBajo() {
        List<Producto> productos = despensaService.obtenerStockBajo();
        return ResponseEntity.ok(productos);
    }


    @GetMapping("/mayor-valor")
    public ResponseEntity<Producto> obtenerProductoMayorValor() {
        Producto producto = despensaService.obtenerProductoMayorValor();
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/resumen")
    public ResponseEntity<ResumenInventario> obtenerResumen() {
        ResumenInventario resumen = despensaService.obtenerResumen();
        return ResponseEntity.ok(resumen);
    }
}