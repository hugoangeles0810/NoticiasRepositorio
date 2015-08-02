/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.dto;

import java.io.Serializable;

/**
 *
 * @author Hugo
 */
public class NoticiaDTO implements Serializable{
    private Integer posicion;
    private Integer id;
    private String titulo, descripcion, enlace;

    public NoticiaDTO() {
    }

    public NoticiaDTO(Integer id, String titulo, String descripcion, String enlace) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.enlace = enlace;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }
}
