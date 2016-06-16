/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.test.service;

import com.dev2012.noticiasunp.dto.NoticiaDTO;
import com.dev2012.noticiasunp.service.NoticiaService;
import com.dev2012.noticiasunp.test.AbstractTestSuite;
import com.dev2012.noticiasunp.util.Paginacion;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class NoticiaServiceTest extends AbstractTestSuite {

    @Autowired
    private NoticiaService noticiaService;

    @Test
    public void paginacionTest() throws Exception {
        System.out.println("------------------------------------------");
        System.out.println("Inicia test paginacion");
        Paginacion pagina = noticiaService.paginacionEditor("asc", 5, 0, "hugoangeles0810@gmail.com", "a");

        List<NoticiaDTO> noticias = (List<NoticiaDTO>) pagina.getRows();
        Long total = pagina.getTotal();
        
        assertNotNull(pagina);
        assertTrue(!noticias.isEmpty());
        
        System.out.println("Total: " + total);
        
        if (noticias != null) {
            System.out.println("Listado: ");
            for (NoticiaDTO noticia : noticias) {
                System.out.println("id: " + noticia.getId());
            }

        }
        System.out.println("Fin test paginacion");
        System.out.println("------------------------------------------");

    }

}
