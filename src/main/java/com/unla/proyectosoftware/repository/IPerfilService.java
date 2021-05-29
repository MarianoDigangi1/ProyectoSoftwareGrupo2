package com.unla.proyectosoftware.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.proyectosoftware.entities.Perfil;

public interface IPerfilService extends JpaRepository<Perfil, Serializable>{

}
