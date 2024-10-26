package com.mitocode.proyectoteamsoft.controller;

import com.mitocode.proyectoteamsoft.dto.BarberoDTO;
import com.mitocode.proyectoteamsoft.dto.GenericResponse;
import com.mitocode.proyectoteamsoft.model.Barbero;
import com.mitocode.proyectoteamsoft.service.IBarberosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barberos")
@RequiredArgsConstructor
public class BarberoController {

  private final IBarberosService service;

  @Qualifier("barberMapper")
  private final ModelMapper modelMapper;


  @GetMapping
  public ResponseEntity<GenericResponse<BarberoDTO>> getAllBarberos() {
    List<BarberoDTO> list = service.findAll().stream().map(this::convertToDto).toList();
   return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
  }

  @PostMapping
  public ResponseEntity<GenericResponse<BarberoDTO>> save(@Valid @RequestBody BarberoDTO dto){
    Barbero obj = service.save(convertToEntity(dto));
    return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(convertToDto(obj))));
  }

  @PutMapping("/{id}")
  public ResponseEntity<GenericResponse<BarberoDTO>> update(@PathVariable("id") Integer id, @Valid @RequestBody BarberoDTO dto) {
    dto.setIdbarbero(id);
    Barbero obj = service.update(id,convertToEntity(dto));
    return ResponseEntity.ok(new GenericResponse<>(200,"success",List.of(convertToDto(obj))));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<GenericResponse<BarberoDTO>> delete(@PathVariable("id") Integer id){
    service.delete(id);
    List<BarberoDTO> list = service.findAll().stream().map(this::convertToDto).toList();
    return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
  }

  private BarberoDTO convertToDto(Barbero obj) {
    return modelMapper.map(obj, BarberoDTO.class);
  }

  private Barbero convertToEntity(BarberoDTO dto) {
    return modelMapper.map(dto, Barbero.class);
  }

}
