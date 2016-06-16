/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.util;

import com.dev2012.noticiasunp.entity.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Hugo
 */
public class SecurityUtil {
    
    public static void logInUserSocial(Usuario usuario){
        UsuarioSession userSocial = UsuarioSession.getBuilder()
                .firstName(usuario.getNombre())
                .lastName(usuario.getApellidos())
                .password(usuario.getClave())
                .role(Role.USER)
                .socialSignInProvider(SocialMediaService.FACEBOOK)
                .username(usuario.getCorreo())
                .imageurl(usuario.getFoto())
                .build();
        Authentication auth = new UsernamePasswordAuthenticationToken(userSocial, null, userSocial.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
