/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.config.Constantes;
import com.dev2012.noticiasunp.dto.NoticiaDTO;
import com.dev2012.noticiasunp.entity.Categoria;
import com.dev2012.noticiasunp.entity.Noticia;
import com.dev2012.noticiasunp.entity.NoticiaCategoria;
import com.dev2012.noticiasunp.repository.NoticiaRepository;
import com.dev2012.noticiasunp.util.Criterio;
import com.dev2012.noticiasunp.util.Paginacion;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
    private NoticiaCategoriaService noticiaCategoriaService;
    
    @Autowired
    private ComentarioService comentarioService;
    
    @Autowired
    public NoticiaServiceImpl(NoticiaRepository publicacionRepository) {
        super(publicacionRepository);
    }

    @Override
    public void agregarNoticia(Noticia noticia, List<Integer> categoriasIds, MultipartFile bannerSmall, MultipartFile bannerLarge) {
        noticia.setBannerSmall("default");
        noticia.setBannerLarge("default");
        noticia.setFechaPublicacion(new Date());
        save(noticia);
        
        for (Integer id : categoriasIds) {
            NoticiaCategoria noticiaCategoria = new NoticiaCategoria();
            noticiaCategoria.setNoticia(noticia);
            noticiaCategoria.setCategoria(new Categoria(id));
            noticiaCategoriaService.save(noticiaCategoria);
        }
        
        File fSmall = new File(Constantes.DIR_IMAGES + noticia.getId() + "-small-" + bannerSmall.getOriginalFilename());
        File fLarge = new File(Constantes.DIR_IMAGES + noticia.getId() + "-large-" + bannerLarge.getOriginalFilename());
        
        imageService.saveImage(bannerSmall, fSmall);
        imageService.saveImage(bannerLarge, fLarge);
        
        noticia.setBannerSmall(fSmall.getName());
        noticia.setBannerLarge(fLarge.getName());
        update(noticia);
    }

    @Override
    public Noticia buscarNoticiaPorEnlace(String enlace) {
        Criterio filtro = Criterio.forClass(Noticia.class);
        filtro.add(Restrictions.eq("enlace", enlace));
        
        List<Noticia> list = searchForCriteria(filtro);
        
        if (list != null && !list.isEmpty()) {
            Noticia noticia = list.get(0);
            noticia.setComentarios(
                    comentarioService.obtenerComentarioPorNoticiaId(noticia.getId()));
            return noticia;
        }
        
        return null;
    }

    @Override
    public List<Noticia> buscarNoticiasPorEnlaceCategoria(String enlace) {
        Criterio filtro = Criterio.forClass(Noticia.class);
        filtro
            .createCriteria("noticiaCategoriaList")
            .createCriteria("categoria")
            .add(Restrictions.eq("enlace", enlace));
        filtro.addOrder(Order.desc("fechaPublicacion"));
        return searchForCriteria(filtro);
    }

    @Override
    public void borrarNoticiaConCategorias(Integer id) {
        Noticia noticia = get(id);
        List<NoticiaCategoria> categorias = noticiaCategoriaService.getNoticiaCategoriaDeNoticiaId(id);
        noticiaCategoriaService.bulkDelete(categorias);
        delete(noticia);
    }

    @Override
    public List<Noticia> buscarNoticiasPorEditor(String emailEditor) {
        Criterio filtro = Criterio.forClass(Noticia.class);
        filtro.createCriteria("usuario").add(Restrictions.eq("correo", emailEditor));
        
        return searchForCriteria(filtro);
    }

    @Override
    public List<Noticia> obtenerNoticiasEnOrdenDeCreacion() {
        Criterio filtro = Criterio.forClass(Noticia.class);
        filtro.addOrder(Order.desc("fechaPublicacion"));
        
        return searchForCriteria(filtro);
    }

    @Override
    public void actualizarNoticia(Noticia noticia, List<Integer> categoriasIds, MultipartFile bannerSmall, MultipartFile bannerLarge) {
        Noticia noticeUpdate = get(noticia.getId());
        noticeUpdate.setTitulo(noticia.getTitulo());
        noticeUpdate.setDescripcion(noticia.getDescripcion());
        noticeUpdate.setContenido(noticia.getContenido());
        noticeUpdate.setEnlace(noticia.getEnlace());
        
        List<NoticiaCategoria> categorias = noticiaCategoriaService.getNoticiaCategoriaDeNoticiaId(noticeUpdate.getId());
        noticiaCategoriaService.bulkDelete(categorias);
        
        for (Integer id : categoriasIds) {
            NoticiaCategoria noticiaCategoria = new NoticiaCategoria();
            noticiaCategoria.setNoticia(noticeUpdate);
            noticiaCategoria.setCategoria(new Categoria(id));
            noticiaCategoriaService.save(noticiaCategoria);
        }
        
        if (bannerSmall.getSize() > 0) {
            File fSmall = new File(Constantes.DIR_IMAGES + noticeUpdate.getId() + "-small-" + bannerSmall.getOriginalFilename());
            imageService.saveImage(bannerSmall, fSmall);
            noticeUpdate.setBannerSmall(fSmall.getName());
        }
        
        if (bannerLarge.getSize() > 0) {
            File fLarge = new File(Constantes.DIR_IMAGES + noticeUpdate.getId() + "-large-" + bannerLarge.getOriginalFilename());
            imageService.saveImage(bannerLarge, fLarge);
            noticeUpdate.setBannerLarge(fLarge.getName());
        }
        
        update(noticeUpdate);
    }

    @Override
    public Paginacion paginacionEditor(String order, 
            Integer limit, Integer offset, String emailEditor, String search) {
        
        List<NoticiaDTO> noticiaDTOs = new ArrayList();
        Criterio filtro = Criterio.forClass(Noticia.class);
        filtro.createCriteria("usuario").add(Restrictions.eq("correo", emailEditor));
        filtro.add(Restrictions.ilike("titulo", "%"+search+"%", MatchMode.ANYWHERE));
        
        Long total = countResultForCriteria(filtro);
        
        filtro.setMaxResults(limit);
        filtro.setFirstResult(offset);
        List<Noticia> noticias = searchForCriteria(filtro);
        
        if (noticias!= null && !noticias.isEmpty()) {
            Integer posicion = offset;
            for (Noticia noticia : noticias) {
                NoticiaDTO n = new NoticiaDTO(noticia.getId(), 
                        noticia.getTitulo(), noticia.getDescripcion(), noticia.getEnlace());
                n.setPosicion(++posicion);
                noticiaDTOs.add(n);
            }
        }
        
        Paginacion pagina = new Paginacion(total, noticiaDTOs);
        
        return pagina;
    }
    
}
