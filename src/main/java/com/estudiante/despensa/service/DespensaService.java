package com.estudiante.despensa.service;

import com.estudiante.despensa.modelo.Producto;
import com.estudiante.despensa.modelo.ResumenInventario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DespensaService {

    private List<Producto> listaProductos = new ArrayList<>();

    public DespensaService() {

        listaProductos.add(new Producto(1L, "Leche Entera", "Lácteos", 2, 12.50));
        listaProductos.add(new Producto(2L, "Queso Fresco", "Lácteos", 5, 25.00));
        listaProductos.add(new Producto(3L, "Arroz Blanco", "Granos", 10, 8.75));
        listaProductos.add(new Producto(4L, "Frijol Negro", "Granos", 3, 9.20));
        listaProductos.add(new Producto(5L, "Detergente en polvo", "Limpieza", 4, 35.00));
        listaProductos.add(new Producto(6L, "Jabón de platos", "Limpieza", 2, 15.50));
    }


    public List<Producto> obtenerTodos() {
        return listaProductos;
    }


    public Producto obtenerPorId(Long id) {
        for (Producto p : listaProductos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }


    public List<Producto> obtenerPorCategoria(String categoria) {
        List<Producto> filtrados = new ArrayList<>();
        for (Producto p : listaProductos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    public List<Producto> obtenerStockBajo() {
        List<Producto> stockBajo = new ArrayList<>();
        for (Producto p : listaProductos) {
            if (p.getCantidad() <= 3) {
                stockBajo.add(p);
            }
        }
        return stockBajo;
    }


    public Producto obtenerProductoMayorValor() {
        if (listaProductos.isEmpty()) {
            return null;
        }
        Producto mayor = listaProductos.get(0);
        for (Producto p : listaProductos) {
            if (p.calcularSubtotal() > mayor.calcularSubtotal()) {
                mayor = p;
            }
        }
        return mayor;
    }


    public ResumenInventario obtenerResumen() {
        int cantidadProductos = listaProductos.size();
        int totalUnidades = 0;
        double valorTotal = 0.0;

        for (Producto p : listaProductos) {
            totalUnidades += p.getCantidad();
            valorTotal += p.calcularSubtotal();
        }

        return new ResumenInventario(cantidadProductos, totalUnidades, valorTotal);
    }
}