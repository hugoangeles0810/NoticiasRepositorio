/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Comentario;
import com.dev2012.noticiasunp.repository.ComentarioRepository;
import com.dev2012.noticiasunp.util.Criterio;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class ComentarioServiceImpl extends BaseServiceImpl<Comentario, Integer>
        implements ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioServiceImpl(ComentarioRepository comentarioRepository) {
        super(comentarioRepository);
    }

    @Override
    public List<Comentario> obtenerComentarioPorNoticiaId(Integer id) {
        Criterio filtro = Criterio.forClass(Comentario.class);
        filtro.createCriteria("noticia").add(Restrictions.eq("id", id));
        
        filtro.setFetchMode("usuario", FetchMode.EAGER);
        filtro.addOrder(Order.desc("fecha"));
        return searchForCriteria(filtro);
    }

}
