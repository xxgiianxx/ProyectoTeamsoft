package com.mitocode.proyectoteamsoft.config;

import com.mitocode.proyectoteamsoft.dto.BarberoDTO;
import com.mitocode.proyectoteamsoft.dto.ClientDTO;
import com.mitocode.proyectoteamsoft.model.Barbero;
import com.mitocode.proyectoteamsoft.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean(name = "defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean(name = "clientMapper")
    public ModelMapper clientMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(Cliente.class, ClientDTO.class)
                .addMapping(Cliente::getIdcliente, (dest, v) -> dest.setIdcliente((Integer) v))
                .addMapping(Cliente::getNombres, (dest, v) -> dest.setNombres((String) v))
                .addMapping(Cliente::getApellidos, (dest, v) -> dest.setApellidos((String) v))
                .addMapping(Cliente::getDni, (dest, v) -> dest.setDni((String) v))
                .addMapping(Cliente::getEdad, (dest, v) -> dest.setEdad((Integer) v));

        mapper.createTypeMap(ClientDTO.class, Cliente.class)
                .addMapping(ClientDTO::getNombres, (dest, v) -> dest.setNombres((String) v))
                .addMapping(ClientDTO::getApellidos, (dest, v) -> dest.setApellidos((String) v))
                .addMapping(ClientDTO::getDni, (dest, v) -> dest.setDni((String) v))
                .addMapping(ClientDTO::getEdad, (dest, v) -> dest.setEdad((Integer) v));

        return mapper;
    }

    @Bean(name = "barberMapper")
    public ModelMapper barberMapper(){

        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(Barbero.class, BarberoDTO.class)
                .addMapping(Barbero::getNombre,(dest,v) -> dest.setNombre((String)v))
                .addMapping(Barbero::getApellidos,(dest,v) -> dest.setApellidos((String)v))
                .addMapping(Barbero::getExperiencia,(dest,v) -> dest.setExperiencia((Integer)v))
                .addMapping(Barbero::getEstado,(dest,v) -> dest.setEstado((Boolean) v));

        mapper.createTypeMap(BarberoDTO.class,Barbero.class)
                .addMapping(BarberoDTO::getNombre,(dest, v) -> dest.setNombre((String)v))
                .addMapping(BarberoDTO::getApellidos,(dest, v) -> dest.setApellidos((String)v))
                .addMapping(BarberoDTO::getExperiencia,(dest, v) -> dest.setExperiencia((Integer)v))
                .addMapping(BarberoDTO::getEstado,(dest, v) -> dest.setEstado((Boolean) v));

        return mapper;
    }



}
