package com.unla.proyectosoftware.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.proyectosoftware.entities.Carrera;
import com.unla.proyectosoftware.entities.Materia;

@Repository("carreraRepository")
public interface IMateriaRepository extends JpaRepository<Materia, Serializable> {

	@Query("select m from Materia m inner join fetch m.carrear mc WHERE mc.idUniversidad  = (:idUniversidad)")
	public List<Materia> findByIdCarrear(@Param ("idCarrera") int idCarrera);
}
