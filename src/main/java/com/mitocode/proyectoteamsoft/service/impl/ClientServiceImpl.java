package com.mitocode.proyectoteamsoft.service.impl;

import com.mitocode.proyectoteamsoft.model.Cliente;
import com.mitocode.proyectoteamsoft.repo.IClientRepo;
import com.mitocode.proyectoteamsoft.repo.IGenericRepo;
import com.mitocode.proyectoteamsoft.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDImpl<Cliente,Integer> implements IClienteService {

    private final IClientRepo repo;
    @Override
    protected IGenericRepo<Cliente, Integer> getRepo() {
        return repo;
    }



}
