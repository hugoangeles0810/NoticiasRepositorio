/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Usuario;
import com.dev2012.noticiasunp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hugo
 */
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer>
                implements UsuarioService{
    
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }
    
}
