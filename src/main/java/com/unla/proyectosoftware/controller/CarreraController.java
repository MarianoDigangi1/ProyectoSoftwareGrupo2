package com.unla.proyectosoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.services.impl.CarreraService;

@Repository
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	@Qualifier("carreraService")
	private CarreraService carreraService;
	
	
}
