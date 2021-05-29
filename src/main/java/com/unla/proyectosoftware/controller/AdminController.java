package com.unla.proyectosoftware.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.models.UniversidadModel;
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
    public IUniversidadService universidadService; 

    @GetMapping("")
    public ModelAndView panel(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_PANEL);
        mV.addObject("universidades", universidadService.traerUniversidades());
        return mV;
    }

    @GetMapping("/alta/universidad")
    public ModelAndView alta(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_ALTA_UNIV);
        mV.addObject("universidad", new UniversidadModel());
        return mV;
    }

    @GetMapping("/modificar/universidad/{id}")
    public ModelAndView modificar(@PathVariable ("id") int id){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_MODIFICAR_UNIV);
        mV.addObject("universidad", new UniversidadModel());
        return mV;
    }


    @PostMapping("/guardar/universidad")
    public RedirectView guardarUniversidad(@ModelAttribute("universidad") UniversidadModel univ, @RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
            String routeImg = "C://Universidades";
            try{
                byte[] bytesImg = file.getBytes();
                Path direcCompleta = Paths.get(routeImg + "//" + file.getOriginalFilename());
                Files.write(direcCompleta,bytesImg);
                univ.setLogo(file.getOriginalFilename());
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }

        
        universidadService.insertOrUpdate(univ);
        return new RedirectView(ViewRouteHelper.ADMIN_ROOT );
    }

    
}
