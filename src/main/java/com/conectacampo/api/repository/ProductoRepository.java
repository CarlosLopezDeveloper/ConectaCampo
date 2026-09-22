package com.conectacampo.api.repository;

import com.conectacampo.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Método para filtrar por categoría y rango de precio (RF-03)
    List<Producto> findByCategoria_IdCategoriaAndPrecioLessThanEqual(Integer idCategoria, BigDecimal precioMax);

    // Listar productos según su categoría
    List<Producto> findByCategoria_IdCategoria(Integer idCategoria);
}
