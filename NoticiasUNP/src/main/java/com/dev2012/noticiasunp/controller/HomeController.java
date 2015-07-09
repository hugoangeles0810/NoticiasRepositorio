/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.controller;

import com.dev2012.noticiasunp.entity.Categoria;
import com.dev2012.noticiasunp.service.CategoriaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author Hugo
 */
@Controller
public class HomeController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("categorias", categoriaService.getAll());
        return mv;
    }
}
