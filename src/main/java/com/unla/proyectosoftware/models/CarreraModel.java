package com.unla.proyectosoftware.models;

import java.util.Set;

public class CarreraModel {
    
    private int idCarrea;
    private String nombre;
    private UniversidadModel universidad;
    private Set<MateriaModel> materias;

    public CarreraModel() {}
    
    public CarreraModel(int idCarrea, String nombre, UniversidadModel universidad) {
        this.idCarrea = idCarrea;
        this.nombre = nombre;
        this.universidad = universidad;
    }

    public CarreraModel(int idCarrea, String nombre, UniversidadModel universidad, Set<MateriaModel> materias) {
        this.idCarrea = idCarrea;
        this.nombre = nombre;
        this.universidad = universidad;
        this.materias = materias;
    }

    public int getIdCarrea() {
        return idCarrea;
    }

    protected void setIdCarrea(int idCarrea) {
        this.idCarrea = idCarrea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UniversidadModel getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadModel universidad) {
        this.universidad = universidad;
    }

    public Set<MateriaModel> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<MateriaModel> materias) {
        this.materias = materias;
    }

    
}
