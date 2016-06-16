/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Categoria;
import com.dev2012.noticiasunp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Integer>
                implements CategoriaService{
    
    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
    }
    
}
