package com.unla.proyectosoftware.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.proyectosoftware.converter.UsuarioConverter;
import com.unla.proyectosoftware.models.UsuarioModel;
import com.unla.proyectosoftware.repository.IUsuarioRepository;
import com.unla.proyectosoftware.services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioConverter usuarioConverter;
	
	public UsuarioModel traerUsuarioYPerfil(String username){
		return usuarioConverter.entityToModel(usuarioRepository.findByUsernameAndFetchPerfilEagerly(username));
	}
}
