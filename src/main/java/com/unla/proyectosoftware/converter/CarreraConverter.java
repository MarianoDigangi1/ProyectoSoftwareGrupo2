package com.unla.proyectosoftware.converter;

import com.unla.proyectosoftware.entities.Carrera;
import com.unla.proyectosoftware.models.CarreraModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carreraConverter")
public class CarreraConverter {
    
    @Autowired
    public UniversidadConverter universidadConverter;

    public Carrera modelToEntity(CarreraModel carreraModel){
        return new Carrera(carreraModel.getIdCarrea(),
                           carreraModel.getNombre(),
                           universidadConverter.modelToEntity(carreraModel.getUniversidad()));
    } 

    public CarreraModel entityToModel(Carrera carrera){
        return new CarreraModel(carrera.getIdCarrea(),
                                carrera.getNombre(),
                                universidadConverter.entityToModel(carrera.getUniversidad()));
    }
}
