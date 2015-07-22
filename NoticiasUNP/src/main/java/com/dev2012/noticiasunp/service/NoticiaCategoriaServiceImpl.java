/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.NoticiaCategoria;
import com.dev2012.noticiasunp.repository.NoticiaCategoriaRepository;
import com.dev2012.noticiasunp.util.Criterio;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class NoticiaCategoriaServiceImpl extends BaseServiceImpl<NoticiaCategoria, Integer>
    implements NoticiaCategoriaService{
    
    @Autowired
    private NoticiaCategoriaRepository noticiaCategoriaRepository;
    
    @Autowired
    public NoticiaCategoriaServiceImpl(NoticiaCategoriaRepository noticiaCategoriaRepository) {
        super(noticiaCategoriaRepository);
    }

    @Override
    public List<NoticiaCategoria> getNoticiaCategoriaDeNoticiaId(Integer id) {
        Criterio filtro = Criterio.forClass(NoticiaCategoria.class);
        filtro.createCriteria("noticia").add(Restrictions.eq("id", id));
        
        return searchForCriteria(filtro);
    }
    
}
