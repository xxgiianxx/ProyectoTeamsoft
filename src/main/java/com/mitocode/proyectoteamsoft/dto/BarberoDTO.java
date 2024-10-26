package com.mitocode.proyectoteamsoft.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BarberoDTO {

    private Integer idbarbero;

    @NotNull(message = "{NotNull.BarberoDTO.nombre}")
    @NotEmpty(message = "{NotEmpty.BarberoDTO.nombre}")
    @Size(min = 3,max = 30)
    private String nombre;

    @NotNull(message = "{NotNull.BarberoDTO.nombre}")
    @NotEmpty(message = "{NotEmpty.BarberoDTO.nombre}")
    @Size(min = 3,max = 30)
    private String apellidos;

    @NotNull(message = "{NotNull.BarberoDTO.experiencia}")
    @Min(value = 1)
    @Max(value = 20)
    private Integer experiencia;

    @NotNull
    private Boolean estado;



}
