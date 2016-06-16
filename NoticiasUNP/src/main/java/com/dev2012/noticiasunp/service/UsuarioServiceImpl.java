/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Usuario;
import com.dev2012.noticiasunp.repository.UsuarioRepository;
import com.dev2012.noticiasunp.util.Criterio;
import com.dev2012.noticiasunp.util.Role;
import com.dev2012.noticiasunp.util.SocialMediaService;
import com.dev2012.noticiasunp.util.UsuarioSession;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer>
                implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }

    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) {
        Criterio filter = Criterio.forClass(Usuario.class);
        filter.add(Restrictions.eq("correo", correo));
        filter.setFetchMode("rol", FetchMode.EAGER);
        filter.setMaxResults(1);
        
        List<Usuario> users = usuarioRepository.searchForCriteria(filter);
        
        if (users!=null && !users.isEmpty()) {
            return users.get(0);
        }
        
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = buscarUsuarioPorCorreo(username);
//        
//        if (usuario == null) {
//            throw new UsernameNotFoundException("No user found with username: " + username);
//        }
//        
//        UsuarioSession principal = UsuarioSession.getBuilder()
//                .firstName(usuario.getNombre())
//                .lastName(usuario.getApellidos())
//                .password(usuario.getClave())
//                .role(Role.ROLE_USER)
//                .socialSignInProvider(SocialMediaService.FACEBOOK)
//                .username(usuario.getCorreo())
//                .build();
//        
//        return principal;
//    }

    @Override
    public Usuario buscarPorProviderYuserId(String providerId, String providerUserId) {
        Criterio filtro = Criterio.forClass(Usuario.class);
        filtro.add(Restrictions.eq("providerid", providerId));
        filtro.add(Restrictions.eq("provideruserid", providerUserId));
        filtro.setMaxResults(1);
        
        List<Usuario> users = searchForCriteria(filtro);
        
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
        
        return null;
    }
    
    
    
}
