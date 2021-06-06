package com.unla.proyectosoftware.services;

import com.unla.proyectosoftware.models.UsuarioModel;

public interface IUsuarioService {

	public UsuarioModel traerUsuarioPorUsername(String username); 
	
	public UsuarioModel traerUsuarioYPerfil(String username);
}
