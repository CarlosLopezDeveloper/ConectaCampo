package com.conectacampo.api.repository;

import com.conectacampo.api.model.ConsultaContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaContactoRepository extends JpaRepository<ConsultaContacto, Integer> {
}