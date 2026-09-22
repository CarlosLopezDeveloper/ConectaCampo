package com.conectacampo.api.repository;

import com.conectacampo.api.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    // Método para buscar un administrador por su correo electrónico (útil para Autenticación / Login - RF-08)
    Optional<Administrador> findByCorreo(String correo);

    // Comprobar si ya existe un administrador registrado con un correo específico
    boolean existsByCorreo(String correo);
}