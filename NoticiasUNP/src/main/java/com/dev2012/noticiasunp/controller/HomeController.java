/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.controller;

import com.dev2012.noticiasunp.config.Constantes;
import com.dev2012.noticiasunp.service.CategoriaService;
import com.dev2012.noticiasunp.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author Hugo
 */
@Controller
public class HomeController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private NoticiaService noticiaService;
    
    @Value("${jdbc.driverClassName}")
    private String facebook;
    
    @Autowired
    private Environment env;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("categorias", categoriaService.getAll());
        mv.addObject("noticias", noticiaService.obtenerNoticiasEnOrdenDeCreacion());
        mv.addObject("DIR_IMAGE", Constantes.URL_DIR_IMAGES);
        mv.addObject("enlace_categoria", "portada");
        System.out.println(facebook);
        System.out.println("facebook: " + env.getProperty("${jdbc.driverClassName}"));
        return mv;
    }
    
    @RequestMapping(value = "/categoria/{enlace}/index.html", method = RequestMethod.GET)
    public ModelAndView categorias(@PathVariable("enlace") String enlace){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("categorias", categoriaService.getAll());
        mv.addObject("noticias", noticiaService.buscarNoticiasPorEnlaceCategoria(enlace));
        mv.addObject("DIR_IMAGE", Constantes.URL_DIR_IMAGES);
        mv.addObject("enlace_categoria", enlace);
        return mv;
    }
}
