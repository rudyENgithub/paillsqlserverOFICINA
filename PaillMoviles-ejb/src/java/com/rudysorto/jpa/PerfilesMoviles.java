/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rsorto
 */
@Entity
@Table(name = "PerfilesMoviles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilesMoviles.findAll", query = "SELECT p FROM PerfilesMoviles p"),
    @NamedQuery(name = "PerfilesMoviles.findByIdPerfilMovil", query = "SELECT p FROM PerfilesMoviles p WHERE p.idPerfilMovil = :idPerfilMovil"),
    @NamedQuery(name = "PerfilesMoviles.findByNombre", query = "SELECT p FROM PerfilesMoviles p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PerfilesMoviles.findByDescripcion", query = "SELECT p FROM PerfilesMoviles p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PerfilesMoviles.findByActivo", query = "SELECT p FROM PerfilesMoviles p WHERE p.activo = :activo")})
public class PerfilesMoviles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdPerfilMovil")
    private Integer idPerfilMovil;
    @Size(max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Activo")
    private Boolean activo;
    @ManyToMany(mappedBy = "perfilesMovilesList")
    private List<AppMoviles> appMovilesList;
    @OneToMany(mappedBy = "idPerfilMovil")
    private List<Usuarios> usuariosList;

    public PerfilesMoviles() {
    }

    public PerfilesMoviles(Integer idPerfilMovil) {
        this.idPerfilMovil = idPerfilMovil;
    }

    public Integer getIdPerfilMovil() {
        return idPerfilMovil;
    }

    public void setIdPerfilMovil(Integer idPerfilMovil) {
        this.idPerfilMovil = idPerfilMovil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<AppMoviles> getAppMovilesList() {
        return appMovilesList;
    }

    public void setAppMovilesList(List<AppMoviles> appMovilesList) {
        this.appMovilesList = appMovilesList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilMovil != null ? idPerfilMovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilesMoviles)) {
            return false;
        }
        PerfilesMoviles other = (PerfilesMoviles) object;
        if ((this.idPerfilMovil == null && other.idPerfilMovil != null) || (this.idPerfilMovil != null && !this.idPerfilMovil.equals(other.idPerfilMovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.PerfilesMoviles[ idPerfilMovil=" + idPerfilMovil + " ]";
    }
    
}
