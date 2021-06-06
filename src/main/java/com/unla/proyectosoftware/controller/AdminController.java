package com.unla.proyectosoftware.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.models.CarreraModel;
import com.unla.proyectosoftware.models.UniversidadModel;
import com.unla.proyectosoftware.services.ICarreraService;
import com.unla.proyectosoftware.services.IUniversidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	@Qualifier("universidadService")
	private IUniversidadService universidadService;
	
	@Autowired
	@Qualifier("carreraService")
	private ICarreraService carreraService;

/*==================== UNIVERSIDAD ====================*/
	
	@GetMapping("")
	public ModelAndView panel() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_PANEL);
		mV.addObject("universidades", universidadService.traerUniversidades());
		return mV;
	}

	@GetMapping("/alta/universidad")
	public ModelAndView alta() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_ALTA_UNIV);
		mV.addObject("universidad", new UniversidadModel());
		return mV;
	}

	@GetMapping("/modificar/universidad/{id}")
	public ModelAndView modificar(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_MODIFICAR_UNIV);
		mV.addObject("universidad", new UniversidadModel());
		return mV;
	}

	@PostMapping("/guardar/universidad")
	public RedirectView guardarUniversidad(@ModelAttribute("universidad") UniversidadModel univ,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String routeImg = "C://Universidades";
			try {
				byte[] bytesImg = file.getBytes();
				Path direcCompleta = Paths.get(routeImg + "//" + file.getOriginalFilename());
				Files.write(direcCompleta, bytesImg);
				univ.setLogo(file.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		universidadService.insertOrUpdate(univ);
		return new RedirectView(ViewRouteHelper.ADMIN_ROOT);
	}

	//NO FUNCIONA Y NO SE PORQUE
	@PostMapping("/eliminar/universidad/{id}")
	public RedirectView eliminarUniversidad(@PathVariable("id") int id) throws Exception{
		universidadService.eliminar(id);
		RedirectView rV = new RedirectView(ViewRouteHelper.ADMIN_ROOT);
		return rV;
	}

/*==================== CARRERA ====================*/
	
	@GetMapping("/listar/{id}")
	public ModelAndView index(@ModelAttribute("carrera") CarreraModel carreraModel, 
							  @PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.CARRERA_INDEX);
		mV.addObject("idUniversidad", id);
		mV.addObject("carrera", carreraService.findAllWithIdUniversidad(id));
		return mV;
	}
	
	@GetMapping("/alta/carrera/{id}")
	public ModelAndView index(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.CARRERRA_NEW);
		mV.addObject("idUniversidad",id);
		mV.addObject("carrera",new CarreraModel());
		return mV;
	}
	
	@PostMapping("/guardar/carrera/{id}")
	public RedirectView guardarCarrera(@ModelAttribute("carrera") CarreraModel carrera,
									   @PathVariable("id") int id) {	
		CarreraModel aux = carrera;
		aux.setUniversidad(universidadService.findByIdUniversidad(id));
		System.out.println(aux);
		carreraService.insertOrUpdate(carrera);
		return new RedirectView(ViewRouteHelper.ADMIN_ROOT);
	}
}

