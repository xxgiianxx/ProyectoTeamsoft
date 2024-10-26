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
public class ClientDTO {

    private Integer idcliente;

    @NotNull
    @Size(min = 3,max = 30)
    private String nombres;

    @NotNull
    @Size(min = 3,max = 30)
    private String apellidos;

    @NotNull(message = "{NotNull.ClienteDTO.dni}")
    @Size(min = 8,max = 8,message = "{Size.ClienteDTO.dni}")
    @Pattern(regexp = "\\d{8}", message = "{Pattern.ClienteDTO.dni}")
    private String dni;

    @NotNull(message = "{NotNull.ClienteDTO.edad}")
    @Min(value = 18,message = "{Min.ClienteDTO.edad}")
    @Max(value = 40,message = "{Max.ClienteDTO.edad}")
    private Integer edad;

}
