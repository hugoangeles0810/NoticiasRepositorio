/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.controller;

import com.dev2012.noticiasunp.config.Constantes;
import com.dev2012.noticiasunp.entity.Noticia;
import com.dev2012.noticiasunp.service.CategoriaService;
import com.dev2012.noticiasunp.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/noticias")
public class NoticiaController {
    
    @Autowired
    private NoticiaService noticiaService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping(value = "/{enlace}.html", method = RequestMethod.GET)
    public ModelAndView noticia(@PathVariable("enlace") String enlace){
        Noticia noticia = noticiaService.buscarNoticiaPorEnlace(enlace);
        
        ModelAndView mv = new ModelAndView("noticia");
        mv.addObject("noticia", noticia);
        mv.addObject("categorias", categoriaService.getAll());
        mv.addObject("DIR_IMAGE", Constantes.URL_DIR_IMAGES);
        
        return mv;
    }
}
