package com.conectacampo.api.controller;

import com.conectacampo.api.model.Producto;
import com.conectacampo.api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permite el consumo desde cualquier frontend
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // RF-02: Visualización Pública de Productos
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    // RF-04: Fichas Técnicas de Productos
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    // RF-03: Filtros de Búsqueda Avanzados
    @GetMapping("/filtrar")
    public ResponseEntity<List<Producto>> filtrarProductos(
            @RequestParam(required = false) Integer categoria,
            @RequestParam(required = false) BigDecimal precioMax) {
        return ResponseEntity.ok(productoService.filtrarPorCategoriaYPrecio(categoria, precioMax));
    }

    // RF-01: Gestión del Catálogo - Crear Producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevo = productoService.guardarProducto(producto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // RF-01: Gestión del Catálogo - Actualizar Producto por ID
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto detallesProducto) {
        // Busca el producto existente por ID
        Producto productoExistente = productoService.obtenerPorId(id);

        // Actualiza los campos con la nueva información
        productoExistente.setNombreProducto(detallesProducto.getNombreProducto());
        productoExistente.setDescripcion(detallesProducto.getDescripcion());
        productoExistente.setFichaTecnica(detallesProducto.getFichaTecnica());
        productoExistente.setPrecio(detallesProducto.getPrecio());
        productoExistente.setDisponibilidad(detallesProducto.getDisponibilidad());
        productoExistente.setUrlImagen(detallesProducto.getUrlImagen());

        if (detallesProducto.getCategoria() != null) {
            productoExistente.setCategoria(detallesProducto.getCategoria());
        }
        if (detallesProducto.getAdministrador() != null) {
            productoExistente.setAdministrador(detallesProducto.getAdministrador());
        }

        // Guarda los cambios en la base de datos
        Producto actualizado = productoService.guardarProducto(productoExistente);
        return ResponseEntity.ok(actualizado);
    }

    // RF-01: Gestión del Catálogo - Eliminar Producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}