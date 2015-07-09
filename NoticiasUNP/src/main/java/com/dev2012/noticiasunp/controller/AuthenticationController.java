/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.controller;

import com.dev2012.noticiasunp.entity.Rol;
import com.dev2012.noticiasunp.entity.Usuario;
import com.dev2012.noticiasunp.service.UsuarioService;
import com.dev2012.noticiasunp.util.EncryptUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Hugo
 */
@Controller
public class AuthenticationController {

    @Autowired
    @Qualifier("authenticationManager")
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/login.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam("j_username") String username,
            @RequestParam("j_password") String password) {

        Map<String, Object> map = new HashMap();
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(username, password);

        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            map.put("success", true);
        } catch (BadCredentialsException e) {
            map.put("success", false);
        }

        return map;
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register.json", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> register(@RequestBody Usuario usuario) {
        Map<String, Object> map = new HashMap();

        if (usuarioService.buscarUsuarioPorCorreo(usuario.getCorreo()) != null) {
            map.put("success", false);
            map.put("error", "El correo ya esta registrado");
        } else {
            try {
                UsernamePasswordAuthenticationToken token
                        = new UsernamePasswordAuthenticationToken(usuario.getCorreo(), usuario.getClave());
                usuario.setFoto("default");
                usuario.setRol(new Rol(1));
                usuario.setClave(EncryptUtil.toSHA1(usuario.getClave()));
                usuarioService.save(usuario);
                Authentication auth = authenticationManager.authenticate(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
                map.put("success", true);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success", false);
                map.put("error", "Error al registrar usuario");
            }

        }

        return map;
    }
}
