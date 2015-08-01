/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Usuario;
import com.dev2012.noticiasunp.util.Role;
import com.dev2012.noticiasunp.util.SocialMediaService;
import com.dev2012.noticiasunp.util.UsuarioSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class RepositoryUserDetailService implements UserDetailsService{
    
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarUsuarioPorCorreo(username);
        
        if (usuario == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
        
        if (usuario.getProviderid() == null) {
            usuario.setProviderid("none");
        }
        
        UsuarioSession principal = UsuarioSession.getBuilder()
                .firstName(usuario.getNombre())
                .lastName(usuario.getApellidos())
                .password(usuario.getClave())
                .role(Role.valueOf(usuario.getRol().getNombre()))
                .socialSignInProvider(SocialMediaService.valueOf(usuario.getProviderid().toUpperCase()))
                .username(usuario.getCorreo())
                .imageurl(usuario.getFoto())
                .build();
        
        return principal;
    }
    
}
