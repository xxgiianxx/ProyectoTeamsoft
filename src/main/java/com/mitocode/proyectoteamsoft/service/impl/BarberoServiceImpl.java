package com.mitocode.proyectoteamsoft.service.impl;

import com.mitocode.proyectoteamsoft.model.Barbero;
import com.mitocode.proyectoteamsoft.repo.IBarberoRepo;
import com.mitocode.proyectoteamsoft.repo.IGenericRepo;
import com.mitocode.proyectoteamsoft.service.IBarberosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarberoServiceImpl extends CRUDImpl<Barbero,Integer> implements IBarberosService {

    private final IBarberoRepo barberoRepo;

    @Override
    protected IGenericRepo<Barbero, Integer> getRepo() {
        return barberoRepo;
    }
}
