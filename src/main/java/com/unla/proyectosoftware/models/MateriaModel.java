package com.unla.proyectosoftware.models;

public class MateriaModel {

    private int idMateria;
    private String nombre;
    private CarreraModel carrera;

    public MateriaModel() {}
    
    public MateriaModel(int idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
    }

    public MateriaModel(int idMateria, String nombre, CarreraModel carrera) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public int getIdMateria() {
        return idMateria;
    }

    protected void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CarreraModel getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraModel carrera) {
        this.carrera = carrera;
    }


    
}
