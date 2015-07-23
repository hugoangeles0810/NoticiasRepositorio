/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.controller;

import com.dev2012.noticiasunp.entity.Noticia;
import com.dev2012.noticiasunp.service.CategoriaService;
import com.dev2012.noticiasunp.service.NoticiaCategoriaService;
import com.dev2012.noticiasunp.service.NoticiaService;
import com.dev2012.noticiasunp.service.UsuarioService;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private NoticiaService noticiaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private NoticiaCategoriaService noticiaCategoriaService;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/editor/index");
        mv.addObject("categorias", categoriaService.getAll());
        mv.addObject("noticias",
                noticiaService.buscarNoticiasPorEditor(
                        SecurityContextHolder.getContext().getAuthentication().getName()));
        return mv;
    }

    @RequestMapping(value = "/new/index.html", method = RequestMethod.POST)
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("/editor/form");
        mv.addObject("categorias", categoriaService.getAll());
        return mv;
    }

    @RequestMapping(value = "/update/index.html", method = RequestMethod.POST)
    public ModelAndView formUpdate(@RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView("/editor/form");
        mv.addObject("noticia", noticiaService.get(id));
        mv.addObject("categorias", categoriaService.getAll());
        mv.addObject("misCategorias", noticiaCategoriaService.getNoticiaCategoriaDeNoticiaId(id));
        return mv;
    }

    @RequestMapping(value = "/delete/index.json", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> deleteNoticia(@RequestBody Integer id) {
        Map<String, Object> map = new HashMap();
        System.out.println(id);
        try {
            noticiaService.borrarNoticiaConCategorias(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping(value = "/guardar-noticia.html", method = RequestMethod.POST)
    public String guardarNoticia(@RequestParam("id") Integer id,
            @RequestParam("titulo") String titulo,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("contenido") String contenido,
            @RequestParam("enlace") String enlace,
            @RequestParam("categoria") List<Integer> categoriaIds,
            @RequestParam("bannerSmall") MultipartFile bannerSmall,
            @RequestParam("bannerLarge") MultipartFile bannerLarge)
            throws UnsupportedEncodingException {
        Noticia noticia = new Noticia();
        noticia.setTitulo(new String(titulo.getBytes("iso-8859-1"), "UTF-8"));
        noticia.setContenido(new String(contenido.getBytes("iso-8859-1"), "UTF-8"));
        noticia.setDescripcion(new String(descripcion.getBytes("iso-8859-1"), "UTF-8"));
        noticia.setEnlace(enlace);

        if (id == null) {
            noticia.setUsuario(usuarioService.buscarUsuarioPorCorreo(
                    SecurityContextHolder.getContext().getAuthentication().getName()
            ));
            noticiaService.agregarNoticia(noticia, categoriaIds, bannerSmall, bannerLarge);
        } else {
            noticia.setId(id);
            noticiaService.actualizarNoticia(noticia, categoriaIds, bannerSmall, bannerLarge);
        }

        return "redirect:/index.html";
    }

    @RequestMapping(value = "/consulta-enlace.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> consultarEnlace(@RequestParam("enlace") String enlace) {
        Map<String, Object> map = new HashMap();
        map.put("valido", noticiaService.buscarNoticiaPorEnlace(enlace) == null);
        return map;
    }

}
