package com.unla.proyectosoftware.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.proyectosoftware.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{

	public Usuario findByUsername(String username);

	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfil WHERE u.username = (:username)")
	public abstract Usuario findByUsernameAndFetchPerfilEagerly(@Param("username") String username);

}
