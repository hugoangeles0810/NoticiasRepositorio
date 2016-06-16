/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Noticia;
import com.dev2012.noticiasunp.util.Paginacion;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Hugo
 */
public interface NoticiaService extends BaseService<Noticia, Integer>{
    
    public void agregarNoticia(Noticia noticia, List<Integer> categoriasIds, MultipartFile bannerSmall, MultipartFile bannerLarge);
    
    public void actualizarNoticia(Noticia noticia, List<Integer> categoriasIds, MultipartFile bannerSmall, MultipartFile bannerLarge);
    
    public Noticia buscarNoticiaPorEnlace(String enlace);
    
    public List<Noticia> buscarNoticiasPorEnlaceCategoria(String enlace);
    
    public void borrarNoticiaConCategorias(Integer id);
    
    public List<Noticia> buscarNoticiasPorEditor(String emailEditor);
    
    public List<Noticia> obtenerNoticiasEnOrdenDeCreacion();
    
    public Paginacion paginacionEditor(String order, Integer limit, Integer offset, String emailEditor, String search);
}
