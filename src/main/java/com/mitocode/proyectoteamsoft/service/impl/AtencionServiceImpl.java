package com.mitocode.proyectoteamsoft.service.impl;

import com.mitocode.proyectoteamsoft.model.Atencion;
import com.mitocode.proyectoteamsoft.repo.IAtencionRepo;
import com.mitocode.proyectoteamsoft.repo.IGenericRepo;
import com.mitocode.proyectoteamsoft.service.IAtencionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtencionServiceImpl extends CRUDImpl<Atencion,Integer> implements IAtencionService {

    private final IAtencionRepo repo;

    @Override
    protected IGenericRepo<Atencion, Integer> getRepo() {
        return repo;
    }


}
