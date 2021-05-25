package com.unla.proyectosoftware.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.unla.proyectosoftware.converter.UniversidadConverter;
import com.unla.proyectosoftware.entities.Universidad;
import com.unla.proyectosoftware.models.UniversidadModel;
import com.unla.proyectosoftware.repository.IUniversidadRespository;
import com.unla.proyectosoftware.services.IUniversidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversidadService implements IUniversidadService{

    @Autowired
    public IUniversidadRespository univRepository;

    @Autowired
    public UniversidadConverter universidadConverter;

    public List<UniversidadModel> traerUniversidades(){
        List<UniversidadModel> universidades= new ArrayList<>();
        for(Universidad u : univRepository.findAll()){
            universidades.add(universidadConverter.entityToModel(u));
        }
        return universidades;
    }

    public void insertOrUpdate(UniversidadModel univ){
        univRepository.save(universidadConverter.modelToEntity(univ));
    }
}
