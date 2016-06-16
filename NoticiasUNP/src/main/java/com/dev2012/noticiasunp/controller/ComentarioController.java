/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.controller;

import com.dev2012.noticiasunp.dto.ComentarioDTO;
import com.dev2012.noticiasunp.entity.Comentario;
import com.dev2012.noticiasunp.entity.Noticia;
import com.dev2012.noticiasunp.entity.Usuario;
import com.dev2012.noticiasunp.service.ComentarioService;
import com.dev2012.noticiasunp.service.UsuarioService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Hugo
 */
@Controller
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/new/index.json", method = RequestMethod.POST)
    public Map<String, Object> guardarComentario(@RequestParam("noticiaId") Integer noticiaId,
            @RequestParam("contenido") String contenido, HttpServletRequest request) {
        Map<String, Object> map = new HashMap();

        try {
            String foto;
            Usuario usuario = usuarioService.buscarUsuarioPorCorreo(
                    SecurityContextHolder.getContext().getAuthentication().getName());

            Noticia noticia = new Noticia(noticiaId);

            Comentario comentario = new Comentario();
            comentario.setContenido(contenido);
            comentario.setNoticia(noticia);
            comentario.setUsuario(usuario);
            comentario.setFecha(new Date());
            
            comentarioService.save(comentario);
            
            foto = usuario.getFoto();
            if (foto == null) {
               foto = request.getContextPath() + "/resources/img/user.png";
            }
            
            ComentarioDTO dto = new ComentarioDTO(comentario, 
                    usuario.getNombre() + usuario.getApellidos(), foto);
            
            map.put("success", true);
            map.put("comentario", dto);
        } catch (Exception e) {
            map.put("success", false);
        }

        return map;
    }

}
