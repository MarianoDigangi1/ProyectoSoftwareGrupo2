package com.unla.proyectosoftware.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.proyectosoftware.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{

	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfil WHERE u.username = (:username)")
	public abstract Usuario findByUsernameAndFetchPerfilEagerly(@Param("username") String username);
}
