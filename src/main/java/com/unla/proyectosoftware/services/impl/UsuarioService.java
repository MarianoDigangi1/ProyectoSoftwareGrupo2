package com.unla.proyectosoftware.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.proyectosoftware.converter.UsuarioConverter;
import com.unla.proyectosoftware.models.UsuarioModel;
import com.unla.proyectosoftware.repository.IUsuarioRepository;
import com.unla.proyectosoftware.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService{

	@Autowired
	@Qualifier("usuarioRepository")
	public IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	public UsuarioConverter usuarioConverter;
	
	@Override
	public UsuarioModel traerUsuarioPorUsername(String username) {
		UsuarioModel usuarioModel = usuarioConverter.entityToModel(usuarioRepository.findByUsername(username));
		return usuarioModel;
	}

	@Override
	public UsuarioModel traerUsuarioYPerfil(String username) {
		return usuarioConverter.entityToModel(usuarioRepository.findByUsernameAndFetchPerfilEagerly(username));
	}
}
