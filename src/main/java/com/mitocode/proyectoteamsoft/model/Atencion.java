package com.mitocode.proyectoteamsoft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idatencion;

    @Column(nullable = false)
    private LocalDateTime fechatencion;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false, foreignKey = @ForeignKey(name = "FK_ATENCION_CLIENTE"))
    private Cliente cliente ;

    @ManyToOne
    @JoinColumn(name = "id_barder", nullable = false, foreignKey = @ForeignKey(name = "FK_ATENCION_BARBERO"))
    private Barbero barbero;

    @Column(nullable = false,length = 35)
    private String tipocorte;

    @Column(nullable = false)
    private Boolean estado;

}