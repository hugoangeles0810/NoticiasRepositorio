/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.dto;

import com.dev2012.noticiasunp.entity.Comentario;
import java.util.Date;

/**
 *
 * @author Hugo
 */
public class ComentarioDTO {
    
    private String contenido;
    private String usuario;
    private String foto;
    private Date fecha;

    public ComentarioDTO() {
    }

    public ComentarioDTO(String contenido, String usuario, String foto, Date fecha) {
        this.contenido = contenido;
        this.usuario = usuario;
        this.foto = foto;
        this.fecha = fecha;
    }
    
    public ComentarioDTO(Comentario comentario, String usuario, String foto){
        this.contenido = comentario.getContenido();
        this.fecha = comentario.getFecha();
        this.usuario = usuario;
        this.foto = foto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
