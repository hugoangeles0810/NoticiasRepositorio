/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.test.service;

import com.dev2012.noticiasunp.service.CategoriaService;
import com.dev2012.noticiasunp.test.AbstractTestSuite;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Hugo
 */
public class CategoriaServiceTest extends AbstractTestSuite{
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Test
    public void crearCategoriaTest() throws Exception{
        assertNotNull(categoriaService);
    }
    
}
