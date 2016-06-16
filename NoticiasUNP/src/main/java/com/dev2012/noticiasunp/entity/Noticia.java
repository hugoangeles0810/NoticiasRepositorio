/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hugo
 */
@Entity
@Table(name = "noticia")
public class Noticia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "banner_small")
    private String bannerSmall;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "banner_large")
    private String bannerLarge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "enlace")
    private String enlace;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noticia", fetch = FetchType.LAZY)
    private List<NoticiaCategoria> noticiaCategoriaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noticia", fetch = FetchType.LAZY)
    private List<Comentario> comentarios;

    public Noticia() {
    }

    public Noticia(Integer id) {
        this.id = id;
    }

    public Noticia(Integer id, String titulo, String contenido, String descripcion, Date fechaPublicacion, String bannerSmall, String bannerLarge, String enlace) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.bannerSmall = bannerSmall;
        this.bannerLarge = bannerLarge;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getBannerSmall() {
        return bannerSmall;
    }

    public void setBannerSmall(String bannerSmall) {
        this.bannerSmall = bannerSmall;
    }

    public String getBannerLarge() {
        return bannerLarge;
    }

    public void setBannerLarge(String bannerLarge) {
        this.bannerLarge = bannerLarge;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<NoticiaCategoria> getNoticiaCategoriaList() {
        return noticiaCategoriaList;
    }

    public void setNoticiaCategoriaList(List<NoticiaCategoria> noticiaCategoriaList) {
        this.noticiaCategoriaList = noticiaCategoriaList;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dev2012.noticiasunp.entity.Noticia[ id=" + id + " ]";
    }
    
}
