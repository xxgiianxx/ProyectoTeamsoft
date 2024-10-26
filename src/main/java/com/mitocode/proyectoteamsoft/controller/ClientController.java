package com.mitocode.proyectoteamsoft.controller;


import com.mitocode.proyectoteamsoft.dto.ClientDTO;
import com.mitocode.proyectoteamsoft.dto.GenericResponse;
import com.mitocode.proyectoteamsoft.model.Cliente;
import com.mitocode.proyectoteamsoft.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClienteService service;

    @Qualifier("clientMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<ClientDTO>>getAllClients() {
        List<ClientDTO> list =service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success", list));
    }

   @PostMapping
    public ResponseEntity<GenericResponse<ClientDTO>> create(@Valid @RequestBody ClientDTO dto) {
       Cliente obj = service.save(convertToEntity(dto));
       return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(convertToDto(obj))));
   }




   @PutMapping("/{id}")
   public ResponseEntity<GenericResponse<ClientDTO>> update(@PathVariable("id") Integer id , @Valid @RequestBody ClientDTO dto) {
       dto.setIdcliente(id);
     Cliente obj = service.update(id,convertToEntity(dto));
     return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<GenericResponse<ClientDTO>> delete(@PathVariable("id") Integer id) {
      service.delete(id);
       List<ClientDTO> list =service.findAll().stream().map(this::convertToDto).toList();
       return ResponseEntity.ok(new GenericResponse<>(200,"success", list));
   }


    private ClientDTO convertToDto(Cliente obj) {
        return modelMapper.map(obj, ClientDTO.class);
    }

    private Cliente convertToEntity(ClientDTO dto) {
        return modelMapper.map(dto, Cliente.class);
    }
}
