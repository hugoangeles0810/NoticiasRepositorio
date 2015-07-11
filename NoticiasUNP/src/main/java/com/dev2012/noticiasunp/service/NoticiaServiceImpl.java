/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.config.Constantes;
import com.dev2012.noticiasunp.entity.Noticia;
import com.dev2012.noticiasunp.repository.NoticiaRepository;
import java.io.File;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Hugo
 */
@Service
public class NoticiaServiceImpl extends BaseServiceImpl<Noticia, Integer>
                implements NoticiaService{
    
    @Autowired
    private ImageService imageService;

    @Autowired
    public NoticiaServiceImpl(NoticiaRepository publicacionRepository) {
        super(publicacionRepository);
    }

    @Override
    public void agregarNoticia(Noticia noticia, MultipartFile bannerSmall, MultipartFile bannerLarge) {
        noticia.setBannerSmall("default");
        noticia.setBannerLarge("default");
        noticia.setFechaPublicacion(new Date());
        save(noticia);
        
        File fSmall = new File(Constantes.DIR_IMAGES + noticia.getId() + "-small-" + bannerSmall.getOriginalFilename());
        File fLarge = new File(Constantes.DIR_IMAGES + noticia.getId() + "-large-" + bannerLarge.getOriginalFilename());
        
        imageService.saveImage(bannerSmall, fSmall);
        imageService.saveImage(bannerLarge, fLarge);
        
        noticia.setBannerSmall(fSmall.getName());
        noticia.setBannerLarge(fLarge.getName());
        System.out.println(fSmall.getName() + "  -   " + fLarge.getName());
        update(noticia);
        
    }
    
}
