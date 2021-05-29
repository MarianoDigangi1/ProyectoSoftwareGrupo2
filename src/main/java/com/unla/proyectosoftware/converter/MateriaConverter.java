package com.unla.proyectosoftware.converter;

import com.unla.proyectosoftware.entities.Materia;
import com.unla.proyectosoftware.models.MateriaModel;

import org.springframework.stereotype.Component;

@Component("materiaConverter")
public class MateriaConverter {
    
    public Materia modelToEntity(MateriaModel materiaModel){
        return new Materia(materiaModel.getIdMateria(),materiaModel.getNombre());
    }

    public MateriaModel entityToModel(Materia materia){
        return new MateriaModel(materia.getIdMateria(),materia.getNombre());
    }
}
