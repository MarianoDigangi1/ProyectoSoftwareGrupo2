package com.unla.proyectosoftware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.proyectosoftware.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.USER_INDEX);
		return mV;
	}
}
