/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.NoticiaCategoria;
import java.util.List;

/**
 *
 * @author Hugo
 */
public interface NoticiaCategoriaService extends BaseService<NoticiaCategoria, Integer>{
    
    public List<NoticiaCategoria> getNoticiaCategoriaDeNoticiaId(Integer id);
    
}
