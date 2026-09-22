package com.conectacampo.api.service.impl;

import com.conectacampo.api.model.Producto;
import com.conectacampo.api.repository.ProductoRepository;
import com.conectacampo.api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));
    }

    @Override
    public List<Producto> filtrarPorCategoriaYPrecio(Integer idCategoria, BigDecimal precioMax) {
        if (idCategoria != null && precioMax != null) {
            return productoRepository.findByCategoria_IdCategoriaAndPrecioLessThanEqual(idCategoria, precioMax);
        } else if (idCategoria != null) {
            return productoRepository.findByCategoria_IdCategoria(idCategoria);
        }
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}