/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Noticia;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Hugo
 */
public interface NoticiaService extends BaseService<Noticia, Integer>{
    
    public void agregarNoticia(Noticia noticia, MultipartFile bannerSmall, MultipartFile bannerLarge);
    
}
