package com.conectacampo.api.service.impl;

import com.conectacampo.api.model.ConsultaContacto;
import com.conectacampo.api.repository.ConsultaContactoRepository;
import com.conectacampo.api.service.ConsultaContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaContactoServiceImpl implements ConsultaContactoService {

    @Autowired
    private ConsultaContactoRepository consultaRepository;

    @Override
    public ConsultaContacto registrarConsulta(ConsultaContacto consulta) {
        // Persiste la solicitud de contacto/cotización técnica en la base de datos MySQL (RF-06)
        return consultaRepository.save(consulta);
    }

    @Override
    public List<ConsultaContacto> obtenerTodas() {
        // Devuelve el listado completo de mensajes enviados por los usuarios
        return consultaRepository.findAll();
    }

    @Override
    public ConsultaContacto obtenerPorId(Integer id) {
        // Busca una consulta específica por su ID o lanza una excepción en caso de no existir
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada con el ID: " + id));
    }

    @Override
    public void eliminarConsulta(Integer id) {
        // Elimina un registro de consulta de la base de datos
        consultaRepository.deleteById(id);
    }
}