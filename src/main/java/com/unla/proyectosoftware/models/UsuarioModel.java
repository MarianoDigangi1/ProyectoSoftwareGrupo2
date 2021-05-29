package com.unla.proyectosoftware.models;

public class UsuarioModel {
	
	private int idUsuario;
	private String username;
	private String password;
	private String email;
	private PerfilModel perfil;
	
	public UsuarioModel() {}

	public UsuarioModel(int idUsuario, String username, String password, String email,
			PerfilModel perfil) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.email = email;
		this.perfil = perfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PerfilModel getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}
	
}


