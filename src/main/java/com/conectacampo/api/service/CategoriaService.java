package com.conectacampo.api.service;

import com.conectacampo.api.model.Categoria;
import java.util.List;

public interface CategoriaService {

    // Obtener la lista completa de categorías
    List<Categoria> obtenerTodas();

    // Buscar una categoría por su ID
    Categoria obtenerPorId(Integer id);

    // Crear o actualizar una categoría
    Categoria guardarCategoria(Categoria categoria);

    // Eliminar una categoría por su ID
    void eliminarCategoria(Integer id);
}
