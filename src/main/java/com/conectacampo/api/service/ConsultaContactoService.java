package com.conectacampo.api.service;

import com.conectacampo.api.model.ConsultaContacto;
import java.util.List;

public interface ConsultaContactoService {

    // Registra una nueva consulta técnica o cotización (RF-06)
    ConsultaContacto registrarConsulta(ConsultaContacto consulta);

    // Obtener todas las consultas recibidas (para panel administrativo)
    List<ConsultaContacto> obtenerTodas();

    // Buscar una consulta específica por su ID
    ConsultaContacto obtenerPorId(Integer id);

    // Eliminar un registro de consulta
    void eliminarConsulta(Integer id);
}