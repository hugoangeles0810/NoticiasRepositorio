/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.repository;

import com.dev2012.noticiasunp.entity.Noticia;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hugo
 */
@Repository
public class NoticiaRepositoryImpl extends BaseRepositoryImpl<Noticia, Integer>
                implements NoticiaRepository{
    
}
