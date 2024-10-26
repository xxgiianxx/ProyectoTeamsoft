package com.mitocode.proyectoteamsoft.controller;

import com.mitocode.proyectoteamsoft.dto.AtencionesDTO;
import com.mitocode.proyectoteamsoft.dto.GenericResponse;
import com.mitocode.proyectoteamsoft.model.Atencion;
import com.mitocode.proyectoteamsoft.service.IAtencionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attentions")
@RequiredArgsConstructor
public class AtencionController {

    private final IAtencionService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;


    @PostMapping
    public ResponseEntity<GenericResponse<AtencionesDTO>> save(@Valid @RequestBody AtencionesDTO dto) {
        Atencion  obj = service.save(convertToEntity(dto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success", List.of(convertToDto(obj))));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<AtencionesDTO>> getAll() {
        List<AtencionesDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<AtencionesDTO>> getById(@PathVariable("id") Integer id) {
        Atencion obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", List.of(convertToDto(obj))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<AtencionesDTO>> update(@PathVariable("id") Integer id, @Valid @RequestBody AtencionesDTO dto) {
        dto.setIdatencion(id);
        Atencion obj = service.update(id,convertToEntity(dto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success",List.of(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<AtencionesDTO>> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        List<AtencionesDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success", list));
    }

    private AtencionesDTO convertToDto(Atencion obj) {
        return modelMapper.map(obj, AtencionesDTO.class);
    }

    private Atencion convertToEntity(AtencionesDTO dto) {
        return modelMapper.map(dto, Atencion.class);
    }

}
