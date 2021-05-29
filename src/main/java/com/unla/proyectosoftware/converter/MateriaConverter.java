package com.unla.proyectosoftware.converter;

import java.util.HashSet;
import java.util.Set;

import com.unla.proyectosoftware.entities.Materia;
import com.unla.proyectosoftware.entities.Profesor;
import com.unla.proyectosoftware.models.MateriaModel;
import com.unla.proyectosoftware.models.ProfesorModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("materiaConverter")
public class MateriaConverter {
    
    @Autowired
    @Qualifier("profesorConverter")
    private ProfesorConverter profesorConverter;
    
    @Autowired
    @Qualifier("carreraConverter")
    private CarreraConverter carreraConverter;

    public Materia modelToEntity(MateriaModel materiaModel){
        Set<Profesor> profesores = new HashSet<>();
        for(ProfesorModel p : materiaModel.getProfesores()){
            profesores.add(profesorConverter.modelToEntity(p));
        }
        return new Materia(materiaModel.getIdMateria(),
                           materiaModel.getNombre(),
                           carreraConverter.modelToEntity(materiaModel.getCarrera()),
                           profesores
                           );
    }

    public MateriaModel entityToModel(Materia materia){
        Set<ProfesorModel> profesores = new HashSet<>();
        for(Profesor p : materia.getProfesores()){
            profesores.add(profesorConverter.entityToModel(p));
        }
        return new MateriaModel(materia.getIdMateria(),
                                materia.getNombre(),
                                carreraConverter.entityToModel(materia.getCarrera()),
                                profesores
                                );
    }
}
