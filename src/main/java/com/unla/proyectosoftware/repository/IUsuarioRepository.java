package com.unla.proyectosoftware.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.proyectosoftware.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{

	public Usuario findByUsername(String username);
}
