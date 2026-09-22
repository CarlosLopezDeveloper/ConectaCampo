package com.conectacampo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre_producto", nullable = false, length = 100)
    private String nombreProducto;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "ficha_tecnica", columnDefinition = "TEXT")
    private String fichaTecnica;

    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    @Column(name = "disponibilidad")
    private Boolean disponibilidad = true;

    @Column(name = "url_imagen", length = 255)
    private String urlImagen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_administrador", nullable = false)
    @JsonIgnoreProperties({"contrasena", "hibernateLazyInitializer", "handler"})
    private Administrador administrador;

    @Column(name = "fecha_actualizacion", insertable = false, updatable = false)
    private java.time.LocalDateTime fechaEnvio;
}