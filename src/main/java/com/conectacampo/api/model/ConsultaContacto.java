package com.conectacampo.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas_contacto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;

    @Column(name = "nombre_remitente", nullable = false, length = 100)
    private String nombreRemitente;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "correo", length = 150)
    private String correo;

    @Column(name = "asunto", nullable = false, length = 150)
    private String asunto;

    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha_envio", insertable = false, updatable = false)
    private java.time.LocalDateTime fechaEnvio;
}
