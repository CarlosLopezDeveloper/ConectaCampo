package com.conectacampo.api.service;

import com.conectacampo.api.model.Producto;
import java.math.BigDecimal;
import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodos();
    Producto obtenerPorId(Integer id);
    List<Producto> filtrarPorCategoriaYPrecio(Integer idCategoria, BigDecimal precioMax);
    Producto guardarProducto(Producto producto);
    void eliminarProducto(Integer id);
}
