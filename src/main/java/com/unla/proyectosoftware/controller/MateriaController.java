package com.unla.proyectosoftware.controller;

public class MateriaController {

//	@Autowired
//	@Qualifier
	
	
//	@GetMapping("/listar/{id}")
//	public ModelAndView index(@ModelAttribute("materia") MateriaModel materiaModel,
//						      @PathVariable("id") int id) {
//		ModelAndView mV = new ModelAndView(ViewRouteHelper.MATERIA_INDEX);
//		mV.addObject("idCarreara" , id);
//		mV.addObject();
//		return mV;
//		
//	}
}
/*
 *@GetMapping("/listar/{id}")
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
 * 
 * */
 