package com.mitocode.proyectoteamsoft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Barbero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbarbero;

    @Column(nullable = false,length = 15)
    private String nombre;

    @Column(nullable = false,length = 30)
    private String apellidos;


    @Column(nullable = false)
    private Integer experiencia;


    @Column(nullable = false)
    private Boolean estado;
}
