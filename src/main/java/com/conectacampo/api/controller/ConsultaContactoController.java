package com.conectacampo.api.controller;

import com.conectacampo.api.model.ConsultaContacto;
import com.conectacampo.api.repository.ConsultaContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin(origins = "*")
public class ConsultaContactoController {

    @Autowired
    private ConsultaContactoRepository consultaRepository;

    // 1. POST: Registrar consulta (RF-06)
    @PostMapping
    public ResponseEntity<ConsultaContacto> registrarConsulta(@RequestBody ConsultaContacto consulta) {
        ConsultaContacto guardada = consultaRepository.save(consulta);
        return new ResponseEntity<>(guardada, HttpStatus.CREATED);
    }

    // 2. GET: Listar todas las consultas
    @GetMapping
    public ResponseEntity<List<ConsultaContacto>> obtenerTodas() {
        List<ConsultaContacto> consultas = consultaRepository.findAll();
        return ResponseEntity.ok(consultas);
    }

    // 3. GET por ID: Obtener consulta por ID
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaContacto> obtenerPorId(@PathVariable Integer id) {
        return consultaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. PUT: Actualizar consulta por ID
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaContacto> actualizarConsulta(@PathVariable Integer id, @RequestBody ConsultaContacto detalles) {
        return consultaRepository.findById(id)
                .map(consultaExistente -> {
                    consultaExistente.setNombreRemitente(detalles.getNombreRemitente());
                    consultaExistente.setTelefono(detalles.getTelefono());
                    consultaExistente.setCorreo(detalles.getCorreo());
                    consultaExistente.setAsunto(detalles.getAsunto());
                    consultaExistente.setMensaje(detalles.getMensaje());
                    ConsultaContacto actualizada = consultaRepository.save(consultaExistente);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE: Eliminar consulta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConsulta(@PathVariable Integer id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}