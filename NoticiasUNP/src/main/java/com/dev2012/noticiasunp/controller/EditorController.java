/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.controller;

import com.dev2012.noticiasunp.entity.Categoria;
import com.dev2012.noticiasunp.entity.Noticia;
import com.dev2012.noticiasunp.service.CategoriaService;
import com.dev2012.noticiasunp.service.NoticiaService;
import com.dev2012.noticiasunp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hugo
 */
@Controller
@RequestMapping("/editor")
public class EditorController {

    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private NoticiaService publicacionService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/editor/index");
        mv.addObject("categorias", categoriaService.getAll());
        return mv;
    }
    
    @RequestMapping(value = "/guardar-noticia.html", method = RequestMethod.POST)
    public String guardarNoticia(@RequestParam("titulo") String titulo, 
                                 @RequestParam("contenido") String contenido,
                                 @RequestParam("descripcion") String descripcion,
                                 @RequestParam("categoria") Integer cateoriaId,
                                 @RequestParam("bannerSmall") MultipartFile bannerSmall,
                                 @RequestParam("bannerLarge") MultipartFile bannerLarge){
        
        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setContenido(contenido);
        noticia.setDescripcion(descripcion);
        noticia.setUsuario(usuarioService.buscarUsuarioPorCorreo(
                SecurityContextHolder.getContext().getAuthentication().getName()
        ));
        publicacionService.agregarNoticia(noticia, bannerSmall, bannerLarge);
        
        return "redirect:/index.html";
    }
    
}

