package com.mitocode.proyectoteamsoft.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtencionesDTO {

    private Integer idatencion;
    @NotNull
    private LocalDateTime fechatencion;

    @NotNull
    private ClientDTO cliente;
    @NotNull
    private BarberoDTO barbero;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\sñÑáéíóúÁÉÍÓÚ]+$", message = "{Pattern.AtencionesDTO.tipocorte}")
    @Size(max = 35, message = "{Max.AtencionesDTO.tipocorte}")
    private String tipocorte;

    @NotNull
    private Boolean estado;
}
