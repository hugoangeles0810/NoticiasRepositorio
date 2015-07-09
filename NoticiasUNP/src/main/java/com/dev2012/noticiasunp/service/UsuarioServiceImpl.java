/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.entity.Usuario;
import com.dev2012.noticiasunp.repository.UsuarioRepository;
import com.dev2012.noticiasunp.util.Criterio;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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
        filter.setMaxResults(1);
        
        List<Usuario> users = usuarioRepository.searchForCriteria(filter);
        
        if (users!=null && !users.isEmpty()) {
            return users.get(0);
        }
        
        return null;
    }
    
}
