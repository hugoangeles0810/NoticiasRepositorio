/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Hugo
 */
public interface UsuarioService extends BaseService<Usuario, Integer>{
    
    public Usuario buscarUsuarioPorCorreo(String correo);
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
