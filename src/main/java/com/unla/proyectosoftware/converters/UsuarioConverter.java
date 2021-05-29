package com.unla.proyectosoftware.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unla.proyectosoftware.entities.Usuario;
import com.unla.proyectosoftware.models.UsuarioModel;

@Component
public class UsuarioConverter {
	
	@Autowired
	private PerfilConverter perfilConverter;
	
	public UsuarioModel entityToModel(Usuario user) {
		UsuarioModel userModel = null;
		if(user != null){
			userModel = new UsuarioModel(user.getId(),
										user.getUsername(),
										user.getPassword(),
										user.getEmail(),
										perfilConverter.entityToModel(user.getPerfil())
										);
		}
		return userModel;
	}
	
	
	public Usuario modelToEntity(UsuarioModel userModel) {
		return new Usuario(userModel.getIdUsuario(),
							userModel.getUsername(),
							userModel.getPassword(),
							userModel.getEmail(),
							perfilConverter.modeltoEntity(userModel.getPerfil())
							);
	}
}
