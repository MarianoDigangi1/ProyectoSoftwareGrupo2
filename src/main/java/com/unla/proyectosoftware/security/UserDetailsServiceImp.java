package com.unla.proyectosoftware.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.unla.proyectosoftware.entities.Perfil;
import com.unla.proyectosoftware.entities.Usuario;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private com.unla.proyectosoftware.repository.IUsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Usuario user = userRepository.findByUsername(username);
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		Perfil perfil = user.getPerfil();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perfil.getNombreRol());
		grantList.add(grantedAuthority);
		UserDetails usuario = (UserDetails) new User(user.getUsername(), user.getPassword(), grantList);
		return usuario;
	}
	
	

}
