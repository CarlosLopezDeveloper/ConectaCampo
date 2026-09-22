package com.conectacampo.api.repository;

import com.conectacampo.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    // Buscar categoría por su nombre exacto
    Optional<Categoria> findByNombreCategoria(String nombreCategoria);

    // Validar si ya existe una categoría registrada con el mismo nombre
    boolean existsByNombreCategoria(String nombreCategoria);
}
