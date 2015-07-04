/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 *
 * @author Hugo
 */
@Controller
public class HomeController {
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String home(){
        return "index";
    }
    
    @RequestMapping(value = "/saludo.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> saludo(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("saludo", "Hola Tarolas");
        return map;
    }
}
