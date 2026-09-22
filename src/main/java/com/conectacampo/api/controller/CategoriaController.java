package com.conectacampo.api.controller;

import com.conectacampo.api.model.Categoria;
import com.conectacampo.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Listar todas las categorías (Para renderizar filtros en el frontend - RF-03)
    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodas() {
        return ResponseEntity.ok(categoriaService.obtenerTodas());
    }

    // Obtener información de una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.obtenerPorId(id));
    }

    // Crear una categoría (Panel de Administración)
    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.guardarCategoria(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    // Actualizar una categoría por ID
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoriaDetalles) {
        // Busca la categoría existente por ID (si no existe, lanza la excepción definida en el servicio)
        Categoria categoriaExistente = categoriaService.obtenerPorId(id);

        // Actualiza los campos con la nueva información recibida
        categoriaExistente.setNombreCategoria(categoriaDetalles.getNombreCategoria());
        categoriaExistente.setDescripcion(categoriaDetalles.getDescripcion());

        // Guarda los cambios en la base de datos
        Categoria categoriaActualizada = categoriaService.guardarCategoria(categoriaExistente);
        return ResponseEntity.ok(categoriaActualizada);
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}