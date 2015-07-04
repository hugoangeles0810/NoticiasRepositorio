/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.test.service;

import com.dev2012.noticiasunp.entity.Categoria;
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
    public void crudCategoriaTest() throws Exception{
        System.out.println("------------------------------------------");
        
        Categoria created = new Categoria();
        created.setNombre("Prueba");
        categoriaService.save(created);
        assertNotNull(created.getId());
        System.out.println("Categoria agregada Id: " + created.getId());
        
        Categoria readed = categoriaService.get(created.getId());
        assertNotNull(readed);
        System.out.println("Categoria leida Id: " + readed.getId());
        
        readed.setNombre("Prueba2");
        categoriaService.update(readed);
        Categoria updated = categoriaService.get(readed.getId());
        assertNotNull(updated);
        System.out.println("Categoria actualizada Nombre: " + updated.getNombre());
        
        Integer id = updated.getId();
        categoriaService.delete(updated);
        Categoria deleted = categoriaService.get(id);
        assertNull(deleted);
        System.out.println("Categoria eliminada Id: " + id);
        
        System.out.println("------------------------------------------");
    }
    
}
