package com.unla.proyectosoftware.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.proyectosoftware.converters.UsuarioConverter;
import com.unla.proyectosoftware.models.UsuarioModel;
import com.unla.proyectosoftware.repository.IUsuarioRepository;
import com.unla.proyectosoftware.services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioConverter usuarioConverter;
	
	@Override
	public UsuarioModel traerUsuarioPorUsername(String username) {
		UsuarioModel usuarioModel = usuarioConverter.entityToModel(usuarioRepository.findByUsername(username));
		return usuarioModel;
	}

}
