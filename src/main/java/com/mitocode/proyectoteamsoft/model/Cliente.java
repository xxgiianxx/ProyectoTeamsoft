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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;

    @Column(nullable = false,length = 30)
    private String nombres;

    @Column(nullable = false,length = 30)
    private String apellidos;


    @Column(nullable = false,length = 8)
    private String dni;


    @Column(nullable = false,length = 2)
    private Integer edad;
}
